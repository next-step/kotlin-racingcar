package step3.view

import step3.racing.Car

object ResultView {
    fun showResult(carList: List<Car>) {
        carList.forEach { car ->
            for (i in 1..car.currentStep()) {
                print("-")
            }
            println()
        }
        println()
    }
}
