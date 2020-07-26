package racing

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val racingState = InputView().input()

        RacingState().validate(racingState)

        val result = RacingCar().start(racingState)
        ResultView().view(result)
    }
}
