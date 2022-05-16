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
        val cars = race(inputView.carNames().map { Car(it) }.toList(), inputView.numberOfLap())
        val winners = getWinners(cars)
        val result = outputView.getResult(cars, winners)
        println("\n실행 결과")
        println(result)
    }

    private fun getWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxByOrNull { it.position }!!.position
        return cars
            .sortedByDescending { it.position }
            .takeWhile { it.position == maxPosition }
    }

    private fun race(cars: List<Car>, numberOfLap: Int): List<Car> {
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
