package step3.view

import step3.racing.Car

object ResultView {
    fun showResult(carList: List<Car>) {
        carList.forEach { car ->
            for (i in MINIMUM_STEP..car.currentStep()) {
                print("-")
            }
            println()
        }
        println()
    }

    private const val MINIMUM_STEP = 1
}
