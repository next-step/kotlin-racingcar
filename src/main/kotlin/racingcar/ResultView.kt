package racingcar

class ResultView(private val progressString: String = "-") {

    fun displayResult(cars: List<Car>) {
        cars.forEach { car ->
            displayCar(car)
        }
        println()
    }

    private fun displayCar(car: Car) {
        repeat(car.now()) {
            print(progressString)
        }
        println()
    }
}
