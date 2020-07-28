package view

import manager.CarManager
import model.Car

class ResultView(private val carManager: CarManager) {
    fun status() {
        println("실행 결과")
        printCarsStep()
    }

    private fun printCarsStep() {
        for (i in 0 until carManager.getTryCount()) {
            println((i + 1).toString() + " 시도")
            for (car in carManager.getCarList()) {
                printStep(car, i)
            }
        }
    }

    private fun printStep(car: Car, tryCount: Int) {
        repeat(car.getStepList()[tryCount]) {
            print(STEP_MARKER)
        }
        println()
    }

    companion object {
        val STEP_MARKER = "-"
    }
}
