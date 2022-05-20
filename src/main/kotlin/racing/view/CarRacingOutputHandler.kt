package racing.view

import racing.domain.Car

object CarRacingOutputHandler {
    fun display(cars: List<Car>) {
        cars.forEach { car ->
            print(car.carName + " : ")
            repeat(car.getMoved()) {
                print(DASH)
            }
            println()
        }
        println()
    }

    private const val DASH = "-"
}
