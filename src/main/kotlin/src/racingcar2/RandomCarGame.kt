package src.racingcar2

object RandomCarGame {
    @JvmStatic
    fun main(args: Array<String>) {
        val (carNumber, tryCount) = InputView.executeInputScreen()
        ResultView.printResult(tryCount, carNumber)
    }
}