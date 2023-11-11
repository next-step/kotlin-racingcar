package racing

import racing.ui.ResultView

class Racing(val cars: List<Car>, val tryCount: Int) {
    fun startRacing(movable: () -> Boolean) {
        for (i in 0 until this.tryCount) {
            this.cars.forEach { car -> move(movable, car) }
        }
        ResultView.printResult(this.cars)
    }

    private fun move(movable: () -> Boolean, car: Car) {
        if (movable()) {
            car.move()
        }
    }
}
