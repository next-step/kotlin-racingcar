package com.nextstep.jngcii.racingcar

import com.nextstep.jngcii.racingcar.domain.RandomDice
import com.nextstep.jngcii.racingcar.domain.Record
import com.nextstep.jngcii.racingcar.view.InputView
import com.nextstep.jngcii.racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carCount = inputView.getCarCount()
    val trialCount = inputView.getTrialCount()

    val record = Record(carCount)
    val dice = RandomDice()

    resultView.printInitialPhase()

    repeat(trialCount) {
        record.goOrStopEachCar(dice)
        record.eachCarDrivenDistance.forEach { resultView.printRoad(it) }
    }
}
