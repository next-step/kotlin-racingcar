package racingcar.ui

class OutputView {

    fun getCurrentProgress(currentProgress: Int): String {
        var stringProgress = ""
        repeat(currentProgress) { stringProgress += "-" }

        return stringProgress
    }
}
