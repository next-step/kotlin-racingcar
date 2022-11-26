package com.jay.racingcar.controller

import com.jay.racingcar.domain.Names
import com.jay.racingcar.domain.RacingCars
import com.jay.racingcar.domain.RandomStrategy
import com.jay.racingcar.domain.Winners
import com.jay.racingcar.view.InputView
import com.jay.racingcar.view.InputView.CAR_NAMES_DELIMITER
import com.jay.racingcar.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
    OutputView.printCarInputMessage()
    val carNames = inputCarNames()
    val names = Names(carNames)

    OutputView.printTryMessage()
    val tries = inputTries()

    val racingCars = RacingCars.create(names, RandomStrategy())

    OutputView.printOutputMessage()
    for (i in 0 until tries) {
        racingCars.play()
        OutputView.printResult(racingCars)
    }

    OutputView.printWinners(Winners(racingCars).getWinners())
}

private fun inputTries(): Int {
    val triesString = InputView.inputMessage()
    require(!triesString.isNullOrEmpty()) { "invalid inputs" }
    return toInt(triesString)
}

private fun inputCarNames(): List<String> {
    val carCountsString = InputView.inputMessage()
    require(!carCountsString.isNullOrEmpty()) { "invalid inputs" }
    return carCountsString.split(CAR_NAMES_DELIMITER)
}

private fun toInt(input: String) = try {
    input.toInt()
} catch (e: NumberFormatException) {
    throw IllegalArgumentException("invalid input - $input")
}
