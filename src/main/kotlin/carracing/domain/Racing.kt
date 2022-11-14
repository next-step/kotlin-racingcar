package carracing.domain

import carracing.ui.OutputView

class Racing(var cars: Cars, private val attemptCount: Int) {

    fun race() {
        for (round in 1..attemptCount) {
            movingCar()
        }
    }

    private fun movingCar() {
        cars._cars.forEach {
            it.move()
            OutputView.gameRoundPrint(it.position)
        }

        OutputView.lineChange()
    }
}
