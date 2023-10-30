package racing

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val cars = CarRacingStarter().ready(carNames)
            val result = CarRacing().race(cars, tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
