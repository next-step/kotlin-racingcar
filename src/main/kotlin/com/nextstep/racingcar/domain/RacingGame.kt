package com.nextstep.racingcar.domain

import com.nextstep.racingcar.view.CliResultView
import com.nextstep.racingcar.view.InputView

class RacingGame(
    private val numberGenerator: NumberGenerator,
    private val moveRule: MoveRule,
    private val inputView: InputView,
    private val resultView: CliResultView
) {

    fun start() {
        val numberOfCars = inputView.inputNumberOfCars()
        val numberOfRounds = inputView.inputNumberOfRounds()

        val cars = (1..numberOfCars).map { Car() }

        resultView.printResult()

        repeat(numberOfRounds) { play(cars) }
    }

    private fun play(cars: List<Car>) {
        cars.map { car ->
            car.move(numberGenerator, moveRule)
            resultView.printResult(car)
        }
        resultView.printLine()
    }
}
