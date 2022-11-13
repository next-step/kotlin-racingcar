package carracing.domain

import carracing.ui.OutputView

class Racing(var cars: List<Car>, var attemptCount: Int) {

    fun race() {
        for (round in 1..attemptCount) {
            movingCar()
        }
    }

    private fun movingCar() {
        for (value in cars.indices) {
            cars[value].move()
            OutputView.gameRoundPrint(cars[value].position)
        }
        OutputView.lineChange()
    }
}
