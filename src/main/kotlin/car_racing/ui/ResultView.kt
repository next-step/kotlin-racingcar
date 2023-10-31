package car_racing.ui

import car_racing.car.Car

class ResultView(
    val tryNumber: Int,
    val cars: MutableList<Car>,
) {
    fun draw() {
        repeat(tryNumber) {
            cars.forEach { car ->
                repeat(car.moveHistory.get(it)) {
                    print("-")
                }
                println()
            }
            println()
        }
    }
}
