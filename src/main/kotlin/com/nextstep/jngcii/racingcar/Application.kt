package com.nextstep.jngcii.racingcar

import com.nextstep.jngcii.racingcar.domain.Car
import com.nextstep.jngcii.racingcar.domain.Game
import com.nextstep.jngcii.racingcar.domain.RandomDice
import com.nextstep.jngcii.racingcar.domain.winners
import com.nextstep.jngcii.racingcar.view.InputView
import com.nextstep.jngcii.racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val cars = inputView.getCarNames().toCarList
    val trialCount = inputView.getTrialCount()

    val dice = RandomDice()
    val game = Game(cars, trialCount, dice)

    resultView.printInitialPhase()

    game.start { resultView.printDistance(it.name, it.distance) }

    resultView.printFinalPhase(cars.winners.map { it.name })
}

private val List<String>.toCarList get() = this.map { Car(it) }
