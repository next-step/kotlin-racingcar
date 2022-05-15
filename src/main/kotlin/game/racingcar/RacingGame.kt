package game.racingcar

import game.racingcar.domain.Car
import game.racingcar.view.InputView
import game.racingcar.view.OutputView
import game.racingcar.view.StandardInputView
import game.racingcar.view.StandardOutputView

class RacingGame(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        inputView.init()
        val cars = start(inputView.numberOfCar, inputView.numberOfLap)
        val result = outputView.getResult(cars)
        println("\n실행 결과")
        println(result)
    }

    private fun start(numberOfCar: Int, numberOfLap: Int): List<Car> {

        val cars = arrayListOf<Car>()

        for (i in 1..numberOfCar) {
            cars.add(Car())
        }

        for (i in 1..numberOfLap) {
            cars.forEach { it.move() }
        }

        return cars
    }
}

fun main() {
    val racingGame = RacingGame(StandardInputView(), StandardOutputView())
    racingGame.run()
}
