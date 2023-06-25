package racing.service

import racing.model.Car

class Racing(carCount: Int) {
    private var cars: List<Car> = List(carCount) { Car() }

    fun play() {
        cars.forEach { car ->
            val moving = car.run()
            print(START_POINT_SYMBOL)
            repeat(moving) {
                print(CAR_SYMBOL)
            }
            println()
        }
        println()
    }

    companion object {
        private const val CAR_SYMBOL = "-"
        private const val START_POINT_SYMBOL = "-"
    }
}
