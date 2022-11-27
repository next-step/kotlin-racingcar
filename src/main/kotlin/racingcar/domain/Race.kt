package racingcar.domain

import racingcar.RandomNumberUtils

class Race(private val cars: List<Car>, private val totalCountOfRound: Int) {
    fun run(): RaceResult {
        val roundHistories = ArrayList<RoundHistory>()

        repeat(totalCountOfRound) { roundNumber: Int ->
            val carPositions = cars.map { car -> car.move(getNumberToMove()) }

            roundHistories.add(RoundHistory(roundNumber, carPositions))
        }

        return RaceResult(roundHistories)
    }

    private fun getNumberToMove(): Int {
        return RandomNumberUtils.getRandomNumber()
    }
}
