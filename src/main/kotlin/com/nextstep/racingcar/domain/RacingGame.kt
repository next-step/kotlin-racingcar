package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.MoveRule
import com.nextstep.racingcar.view.InputView
import com.nextstep.racingcar.view.ResultView

class RacingGame(
    private val moveRule: MoveRule,
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun start() {
        val carNames = inputView.inputCarNames()
        val numberOfRounds = inputView.inputNumberOfRounds()

        val cars = carNames.map { Car(it) }

        resultView.printResult()

        repeat(numberOfRounds) { play(cars) }
    }

    private fun play(cars: List<Car>) {
        cars.forEach {
            it.move(moveRule)
            resultView.printResult(it)
        }
        resultView.printLine()
    }
}
