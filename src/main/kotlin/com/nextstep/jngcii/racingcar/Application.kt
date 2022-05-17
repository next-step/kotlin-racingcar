package com.nextstep.jngcii.racingcar

import com.nextstep.jngcii.racingcar.domain.Game
import com.nextstep.jngcii.racingcar.domain.RandomDice
import com.nextstep.jngcii.racingcar.domain.Record
import com.nextstep.jngcii.racingcar.view.InputView
import com.nextstep.jngcii.racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carCount = inputView.getCarCount()
    val trialCount = inputView.getTrialCount()

    val record = Record(carCount, trialCount)
    val dice = RandomDice()
    val game = Game(record, dice)

    game.start()

    resultView.printResult(record)
}
