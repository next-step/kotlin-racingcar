package racing

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val cars = carNames.map { Car(it) }
            val result = CarRacing().race(cars, tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
