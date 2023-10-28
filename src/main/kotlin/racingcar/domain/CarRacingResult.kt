package racingcar.domain

class CarRacingResult private constructor(
    private val resultByRound: MutableMap<Int, RoundResult>,
) {
    companion object {
        fun createInitialResult(
            configuration: CarRacingResultConfiguration,
            createInitialRoundResult: () -> RoundResult,
        ): CarRacingResult {
            val resultByRound = mutableMapOf<Int, RoundResult>()
            configuration.rounds.forEach { round ->
                resultByRound[round] = createInitialRoundResult()
            }
            return CarRacingResult(resultByRound)
        }
    }
}
