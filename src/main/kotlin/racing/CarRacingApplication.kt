package racing

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (tryCount, carCount) = InputView.inputForRacing()
            val result = CarRacing.race(tryCount, carCount)
            ResultView.printRacingResult(result)
        }
    }
}
