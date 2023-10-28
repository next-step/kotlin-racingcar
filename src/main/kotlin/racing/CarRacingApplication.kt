package racing

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (carCount, tryCount) = InputView.inputForRacing()
            val result = CarRacing.race(carCount, tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
