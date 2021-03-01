package racingcar.ui

class OutputView {

    fun getStringProgress(currentProgress: Int): String {
        var stringProgress = ""
        repeat(currentProgress) { stringProgress += "-" }

        return stringProgress
    }
}
