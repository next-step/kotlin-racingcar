package racing

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = InputView().input()
        val result = RacingCar().start(input)
        ResultView().view(result)
    }
}
