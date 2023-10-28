package racingcar.domain

import java.lang.IllegalArgumentException

class CarRacingResult private constructor(
    private val resultByRoundNumber: MutableMap<Int, RoundResult>,
) {
    fun record(roundNumber: Int, cars: List<Car>) {
        val roundResult = resultByRoundNumber[roundNumber] ?: throw IllegalArgumentException("설정된 라운드가 아닙니다")
        roundResult.record(cars)
    }

    fun getRoundResult(roundNumber: Int): RoundResult =
        resultByRoundNumber[roundNumber] ?: throw IllegalArgumentException("기록된 경기가 아닙니다")

    companion object {
        fun createInitialResult(
            configuration: CarRacingResultConfiguration,
            createInitialRoundResult: () -> RoundResult,
        ): CarRacingResult {
            val resultByRound = mutableMapOf<Int, RoundResult>()
            configuration.roundRange.forEach { round ->
                resultByRound[round] = createInitialRoundResult()
            }
            return CarRacingResult(resultByRound)
        }
    }
}
