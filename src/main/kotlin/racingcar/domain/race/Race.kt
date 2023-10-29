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
        val roundResult = mutableListOf<Int>()

        cars.forEach {
            moveIfCan(it, racePolicy)
            roundResult.add(it.position)
        }

        return roundResult
    }

    private fun moveIfCan(car: Car, racePolicy: RacePolicy) {
        if (racePolicy.moveCondition.invoke()) {
            car.move(racePolicy.moveAmount)
        }
    }

    private fun getWinners(): List<String> {
        val winners = mutableListOf<String>()

        var maxPosition = 0

        cars.forEach {
            if (it.position > maxPosition) {
                winners.clear()
                winners.add(it.name)
                maxPosition = it.position
            } else if (it.position == maxPosition) {
                winners.add(it.name)
            }
        }

        return winners
    }
}
