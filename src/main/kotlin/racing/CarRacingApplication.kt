package racing

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = InputView.inputForRacing()
            val result = CarRacing.race(input)
            ResultView.printRacingResult(result)
        }
    }
}
