package racingCar.controller

import racingCar.domain.Racing
import racingCar.domain.RandomStrategy
import racingCar.view.InputView
import racingCar.view.OutputView
import java.util.stream.IntStream

fun main() {
    val racing = Racing(getCarNumber(), RandomStrategy())
    val tryNumber = getTryNumber()
    OutputView.printResultMsg()
    IntStream.range(0, tryNumber)
        .forEach {
            val result = racing.play()
            OutputView.printResult(result)
        }
}

private fun getTryNumber(): Int {
    OutputView.askTryNumber()
    return InputView.getNumber()
}

private fun getCarNumber(): Int {
    OutputView.askCarNumber()
    return InputView.getNumber()
}
