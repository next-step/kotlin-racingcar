package racingcar.domain.race

import racingcar.domain.car.Car

class Race(
    private val cars: List<Car>,
    private val totalRound: Int,
    private val racePolicy: RacePolicy,
) {
    init {
        require(cars.isNotEmpty()) { "Racing game need at least 1 car" }
        require(totalRound >= 1) { "Racing game need at least 1 round" }
    }

    fun start(): RaceResult {
        val roundResults = List(totalRound) { doRound() }

        return RaceResult(
            resultPerRound = roundResults,
            winners = getWinners(),
        )
    }

    private fun doRound(): List<Int> {
        return cars.map {
            moveIfCan(it, racePolicy)
            it.position
        }
    }

    private fun moveIfCan(car: Car, racePolicy: RacePolicy) {
        if (racePolicy.moveCondition.invoke()) {
            car.move(racePolicy.moveAmount)
        }
    }

    private fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }

        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }
}
