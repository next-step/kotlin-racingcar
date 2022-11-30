package racingcar.domain

import racingcar.RandomNumberUtils

class Race(private val cars: List<Car>, private val totalCountOfRound: Int) {
    fun run(): RaceResult {
        val roundHistories = ArrayList<RoundHistory>()

        repeat(totalCountOfRound) { roundNumber ->
            val carInfos = cars.map { car -> Pair(car.name, car.move(getNumberToMove())) }

            roundHistories.add(RoundHistory(roundNumber, carInfos))
        }

        return RaceResult(roundHistories)
    }

    private fun getNumberToMove(): Int {
        return RandomNumberGenerator.getRandomNumber()
    }
}
