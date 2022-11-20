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

        val cars = Cars(carNames)

        resultView.printBeforeResult()

        repeat(numberOfRounds) {
            cars.play(moveRule)
            resultView.printBeforeResult(cars)
        }
    }
}
