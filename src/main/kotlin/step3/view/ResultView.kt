package step3.view

import step3.racing.Car

object ResultView {
    fun showResult(carList: List<Car>) {
        carList.forEach { car ->
            showSingleCarRacingResult(car)
            println()
        }
        println()
    }

    private fun showSingleCarRacingResult(car: Car) {
        for (i in MINIMUM_STEP..car.currentStep()) {
            print("-")
        }
    }

    private const val MINIMUM_STEP = 1
}
