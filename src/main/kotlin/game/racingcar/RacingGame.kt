package game.racingcar

import game.racingcar.domain.Car
import game.racingcar.strategy.MoveStrategy
import game.racingcar.strategy.RandomMoveStrategy
import game.racingcar.view.InputView
import game.racingcar.view.OutputView
import game.racingcar.view.StandardInputView
import game.racingcar.view.StandardOutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val moveStrategy: MoveStrategy,
) {
    fun run() {
        inputView.init()
        val cars = start(inputView.numberOfCar(), inputView.numberOfLap)
        val result = outputView.getResult(cars)
        println("\n실행 결과")
        println(result)
    }

    private fun start(numberOfCar: Int, numberOfLap: Int): List<Car> {

        val cars = arrayListOf<Car>()

        for (i in 0 until numberOfCar) {
            cars.add(Car())
        }

        for (i in 0 until numberOfLap) {
            cars.forEach { it.move(moveStrategy) }
        }

        return cars
    }
}

fun main() {
    val racingGame = RacingGame(StandardInputView(), StandardOutputView(), RandomMoveStrategy())
    racingGame.run()
}
