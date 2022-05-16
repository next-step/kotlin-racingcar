package racingcar.view

import racingcar.domain.GameResult

class OutputView {
    fun printGameResult(gameResult: GameResult) {
        println("\n실행 결과")
        print(getStringRepresentativeOfGameResult(gameResult))
        print("\n\n")
        print(getStringRepresentativeOfGameWinners(gameResult))
    }

    private fun getStringRepresentativeOfGameResult(gameResult: GameResult): String {
        return gameResult.get().joinToString(TRIAL_SEPARATOR) { trialResult ->
            trialResult.get().joinToString(CAR_SEPARATOR) { car -> "${car.name} : ${CAR_ICON.repeat(car.position + 1)}" }
        }
    }

    private fun getStringRepresentativeOfGameWinners(gameResult: GameResult): String {
        return "${gameResult.winners.joinToString(", ")}가 최종 우승했습니다."
    }

    companion object {
        private const val CAR_ICON = "-"
        private const val CAR_SEPARATOR = "\n"
        private const val TRIAL_SEPARATOR = "\n\n"
    }
}
