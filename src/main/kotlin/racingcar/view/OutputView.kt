package racingcar.view

import racingcar.GameResult

class OutputView {
    fun printGameResult(gameResult: GameResult) {
        println("\n실행 결과")
        print(getStringRepresentativeOfGameResult(gameResult))
    }

    private fun getStringRepresentativeOfGameResult(gameResult: GameResult): String {
        return gameResult.get().joinToString(TRIAL_SEPARATOR) { trialResult ->
            trialResult.get().joinToString(CAR_SEPARATOR) { car -> CAR_ICON.repeat(car.position) }
        }
    }

    companion object {
        private const val CAR_ICON = "-"
        private const val CAR_SEPARATOR = "\n"
        private const val TRIAL_SEPARATOR = "\n\n"
    }
}
