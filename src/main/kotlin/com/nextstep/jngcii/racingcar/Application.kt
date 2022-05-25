package com.nextstep.jngcii.racingcar

import com.nextstep.jngcii.racingcar.domain.Car
import com.nextstep.jngcii.racingcar.domain.Cars
import com.nextstep.jngcii.racingcar.domain.Game
import com.nextstep.jngcii.racingcar.domain.History
import com.nextstep.jngcii.racingcar.domain.RandomDice
import com.nextstep.jngcii.racingcar.view.InputView
import com.nextstep.jngcii.racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val names = inputView.getCarNames()
    val dice = RandomDice()
    val cars = Cars(
        cars = names.map { Car(name = it, dice = dice) }
    )
    val history = History(cars)
    val trialCount = inputView.getTrialCount()

    val game = Game(cars, trialCount, history)

    game.start()

    resultView.print(history)
}
