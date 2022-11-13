package racingCar.controller

import racingCar.domain.Racing
import racingCar.domain.RandomStrategy
import racingCar.view.InputView
import racingCar.view.OutputView
import java.util.stream.IntStream

fun main() {
    OutputView.askCarNumber()
    val carNumber = InputView.number()
    val racing = Racing(carNumber, RandomStrategy())
    OutputView.askTryNumber()
    val tryNumber = InputView.number()
    OutputView.printResultMsg()
    (0..tryNumber).forEach {
        val result = racing.play()
        OutputView.printResult(result)

    }
}
