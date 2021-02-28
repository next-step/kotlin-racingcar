package racingcar.ui

class OutputView {

    fun getCurrentProgress(currentPosition: Int): String {
        var stringProgress = ""
        repeat(currentPosition) { stringProgress += "-" }

        return stringProgress
    }
}
