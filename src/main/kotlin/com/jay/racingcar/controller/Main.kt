package com.jay.racingcar.controller

import com.jay.racingcar.domain.RacingCars
import com.jay.racingcar.domain.RandomStrategy
import com.jay.racingcar.view.InputView
import com.jay.racingcar.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
    InputView.printCarInputMessage()
    val carCountsString = InputView.inputMessage()
    require(!carCountsString.isNullOrEmpty()) { "invalid inputs" }
    val carCount = toInt(carCountsString)

    InputView.printTryMessage()
    val triesString = InputView.inputMessage()
    require(!triesString.isNullOrEmpty()) { "invalid inputs" }
    val tries = toInt(triesString)

    val racingCars = RacingCars.create(carCount, RandomStrategy())

    OutputView.printOutputMessage()
    for (i in 0 until tries) {
        racingCars.play()
        OutputView.printResult(racingCars)
    }
}

private fun toInt(input: String) = try {
    input.toInt()
} catch (e: NumberFormatException) {
    throw IllegalArgumentException("invalid input - $input")
}
