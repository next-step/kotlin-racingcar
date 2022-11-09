package racingcar

class ResultView(private val progressCharacter: String = "-") {

    fun displayResult(cars: List<Car>) {
        cars.forEach { car ->
            displayCar(car)
        }
        println()
    }

    private fun displayCar(car: Car) {
        repeat(car.now()) {
            print(progressCharacter)
        }
        println()
    }
}
