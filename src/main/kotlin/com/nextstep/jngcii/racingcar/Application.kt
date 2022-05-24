package com.nextstep.jngcii.racingcar

import com.nextstep.jngcii.racingcar.domain.Car
import com.nextstep.jngcii.racingcar.domain.Cars
import com.nextstep.jngcii.racingcar.domain.Game
import com.nextstep.jngcii.racingcar.domain.RandomDice
import com.nextstep.jngcii.racingcar.view.InputView
import com.nextstep.jngcii.racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val dice = RandomDice()

    val names = inputView.getCarNames()
    val cars = Cars(
        cars = names.map { Car(name = it, dice = dice) }
    )
    val trialCount = inputView.getTrialCount()

    val game = Game(cars, trialCount)

    resultView.printInitialPhase()

    game.start { resultView.printDistance(it.name, it.distance) }

    resultView.printFinalPhase(cars.winners.map { it.name })
}
