package racing

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val (results, winners) = CarRacing.race(carNames, tryCount)
            ResultView.printRacingResult(results, winners)
        }
    }
}
