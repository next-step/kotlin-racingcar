package racingcar.domain

import java.lang.IllegalArgumentException

class CarRacingResult private constructor(
    private val resultByRoundNumber: MutableMap<Int, CarRacingRoundResult>,
) {
    fun record(roundNumber: Int, cars: List<Car>) {
        val roundResult = resultByRoundNumber[roundNumber] ?: throw IllegalArgumentException("설정된 라운드가 아닙니다")
        roundResult.record(cars)
    }

    fun showCarPositionsByRoundInOrder(): List<List<Int>> {
        val roundResultsInOrder = resultByRoundNumber.entries.sortedBy { it.key }.map { it.value }
        return roundResultsInOrder.map { it.getCarPositionsInorder() }
    }

    companion object {
        fun createInitialResult(
            configuration: CarRacingResultConfiguration,
        ): CarRacingResult {
            val resultByRound = mutableMapOf<Int, CarRacingRoundResult>()
            val roundRange = configuration.roundRange
            val cars = configuration.cars
            roundRange.forEach { roundNumber ->
                resultByRound[roundNumber] = CarRacingRoundResult.createInitialResult(cars)
            }
            return CarRacingResult(resultByRound)
        }
    }
}
