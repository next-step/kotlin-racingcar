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
        )
    }

    private fun doRound(): List<Int> {
        val roundResult = mutableListOf<Int>()

        cars.forEach {
            if (racePolicy.moveCondition.invoke()) {
                it.move(racePolicy.moveAmount)
            }
            roundResult.add(it.position)
        }

        return roundResult
    }
}
