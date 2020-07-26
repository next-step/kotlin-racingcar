package racing

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = InputView().input()
        RacingCar().start(input)
    }
}
