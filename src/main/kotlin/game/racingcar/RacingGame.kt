package game.racingcar

import game.racingcar.domain.Car
import game.racingcar.view.InputView
import game.racingcar.view.OutputView

class RacingGame(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        inputView.init()
        val cars = start(inputView.numberOfCar, inputView.numberOfLap)
        val result = outputView.getResult(cars)
        println("\n실행 결과")
        println(result)
    }

    private fun start(numberOfCar: Int, numberOfLap: Int): List<Car> {
        println(numberOfCar)
        println(numberOfLap)
        return listOf()
    }
}

fun main() {
    // val racingGame = RacingGame(InputView(), OutputView())
    // racingGame.run()
}
