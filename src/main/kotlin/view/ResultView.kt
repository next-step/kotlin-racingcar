package view

import manager.CarManager
import model.Car

class ResultView(private val carManager: CarManager) {
    fun status() {
        run {
            println()
            println("실행 결과")
            printCarsStep()
            printCarsWinner()
        }
    }

    private fun printCarsStep() {
        for (i in 0 until carManager.tryCount) {
            printCar(i)
            println()
        }
    }

    private fun printCar(i: Int) {
        for (car in carManager.getCarList()) {
            printStep(car, i).invoke()
        }
    }

    private fun printStep(car: Car, tryCount: Int): () -> Unit = {
        print(car.driverName + " : ")
        repeat(car.stepList[tryCount]) {
            print(STEP_MARKER)
        }
        println()
    }

    private fun printCarsWinner() {
        print(carManager.getCarWinners().map { it.driverName }.joinToString(", "))
        print("가 최종 우승했습니다.")
    }

    companion object {
        val STEP_MARKER = "-"
    }
}
