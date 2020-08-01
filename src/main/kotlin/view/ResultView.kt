package view

import manager.CarManager
import model.Car

class ResultView(private val carManager: CarManager) {
    fun status() {
        println()
        println("실행 결과")
        printCarsStep()
        printCarsWinner()
    }

    private fun printCarsStep() {
        for (i in 0 until carManager.tryCount) {
            printCar(i)
            println()
        }
    }

    private fun printCar(i: Int) {
        for (car in carManager.carList) {
            printStep(car, i).invoke()
        }
    }

    private fun printStep(car: Car, tryCount: Int): () -> Unit = {
        print(stepToString(car, tryCount) + "\n")
    }

    fun stepToString(car: Car, tryCount: Int): String {
        val sb = StringBuilder()
        sb.append(car.driverName + " : ")
        repeat(car.stepList[tryCount]) {
            sb.append(STEP_MARKER)
        }
        return sb.toString()
    }

    private fun printCarsWinner() {
        print(carManager.getCarWinners().map { it.driverName }.joinToString(", "))
        print("가 최종 우승했습니다.")
    }

    companion object {
        val STEP_MARKER = "-"
    }
}
