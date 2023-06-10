package race

import race.view.InputView
import race.view.ResultView

class Race {
    private val inputView = InputView()
    private val resultView = ResultView()

    private val cars = mutableListOf<Car>()
    private var numberOfTry = 0

    fun run() {
        prepare()
        start()
    }

    private fun prepare() {
        val inputData = inputView.input()

        val numberOfCar = inputData.numberOfCar
        numberOfTry = inputData.numberOfTry

        repeat(numberOfCar) {
            cars.add(Car())
        }
    }

    private fun start() {
        println("실행 결과")

        repeat(numberOfTry) {
            cars.forEach { it.move() }
            resultView.showAllPosition(cars)
        }
    }
}

fun main() {
    Race().run()
}
