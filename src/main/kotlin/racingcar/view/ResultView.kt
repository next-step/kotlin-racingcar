package racingcar.view

import racingcar.domain.Car

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

    fun displayWinner(cars: List<Car>) {
        val names = cars.map { car ->
            car.name
        }

        println("${names.joinToString()}가 최종 우승했습니다. ")
    }
}
