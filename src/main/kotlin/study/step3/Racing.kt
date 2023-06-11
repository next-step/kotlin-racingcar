package study.step3

import study.step3.inputview.InputView
import study.step3.resultview.ResultView

class Racing(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun start() {
        val (numOfCar, numOfAttempt) = inputView.receive()
        runStages(numOfAttempt, createCars(numOfCar))
    }

    private fun runStages(totalRounds: Long, cars: List<Car>) {
        println("실행 결과")

        (0 until totalRounds).forEach { _ ->
            cars.forEach { it.move() }
            resultView.printResult(cars)
        }
    }

    private fun createCars(numOfCar: Long): List<Car> {
        return (0 until numOfCar).map { Car(RandomMovementConditionGenerator()) }
    }
}
