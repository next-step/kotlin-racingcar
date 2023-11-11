package racing

import racing.ui.ResultView

class Racing(val cars: List<Car>, val tryCount: Int) {
    fun startRacing(movable: () -> Boolean): List<Car> {
        for (i in 0 until this.tryCount) {
            this.cars.filter { movable() }.forEach { it.move() }
        }
        ResultView.printResult(this.cars)
        return this.cars
    }
}
