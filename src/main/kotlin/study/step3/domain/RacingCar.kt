package study.step3.domain

import study.step3.view.InputView

class RacingCar {

    fun raceStart() {
        val carNum = InputView.inputNumberOfCars()
        val movingNum = InputView.inputNumberOfMoving()

        val carList = List(carNum) {}.map { Car() }

        for (i in 0..movingNum) {
            carList.forEach { it.moveOneStep() }
            carList.forEach { it.printCurrentStep(); println() }
            println()
        }
    }
}
