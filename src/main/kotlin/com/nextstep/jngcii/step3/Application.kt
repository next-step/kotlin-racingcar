package com.nextstep.jngcii.step3

import com.nextstep.jngcii.step3.domain.Game
import com.nextstep.jngcii.step3.domain.RandomDice
import com.nextstep.jngcii.step3.domain.Record
import com.nextstep.jngcii.step3.view.InputView
import com.nextstep.jngcii.step3.view.ResultView

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
