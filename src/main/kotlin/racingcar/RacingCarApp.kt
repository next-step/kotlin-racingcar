package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.ui.InputView.printInputRacingCarCount
import racingcar.ui.InputView.printInputRacingCount
import racingcar.ui.ResultView.printResult

fun main() {
    printInputRacingCarCount()

    val racingCarCount = readLine()?.toInt() ?: 0

    var cars = Cars()
    repeat(racingCarCount) {
        cars += Car()
    }

    printInputRacingCount()

    val racingCount = readLine()?.toInt() ?: 0

    printResult(cars, racingCount)
}

