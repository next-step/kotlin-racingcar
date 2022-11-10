package racingcar

class ResultView(private val progressCharacter: String = "-") {

    fun displayResult(cars: List<Car>) {
        cars.forEach { car ->
            displayCar(car)
        }
        println()
    }

    private fun displayCar(car: Car) {
        print("${car.name} : ")
        repeat(car.progress) {
            print(progressCharacter)
        }
        println()
    }
}
