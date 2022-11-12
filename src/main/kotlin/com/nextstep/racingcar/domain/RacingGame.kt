package com.nextstep.racingcar.domain

import com.nextstep.racingcar.view.InputView
import com.nextstep.racingcar.view.ResultView

class RacingGame(private val numberGenerator: NumberGenerator, private val moveRule: MoveRule) {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun start() {
        val numberOfCars = inputView.inputNumberOfCars()
        val numberOfRounds = inputView.inputNumberOfRounds()

        val cars = mutableListOf<Car>()
        for (i in 1..numberOfCars) {
            cars.add(Car())
        }

        resultView.printResult()
        for (round in 1..numberOfRounds) {
            play(cars)
        }
    }

    private fun play(cars: List<Car>) {
        for (car in cars) {
            car.move(numberGenerator, moveRule)
            resultView.printResult(car)
        }
        resultView.printLine()
    }
}
