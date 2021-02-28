package racingcar

class OutputView {

    fun printCurrentPosition(currentPosition: Int): String {
        var stringProgress = ""
        repeat(currentPosition) { stringProgress += "-" }

        return stringProgress
    }
}
