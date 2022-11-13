package racingCar.controller

import racingCar.domain.Racing
import racingCar.domain.RandomStrategy
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    OutputView.askUsernames()
    val usernames = InputView.usernames()
    val racing = Racing(usernames, RandomStrategy())
    OutputView.askTryNumber()
    val tryNumber = InputView.number()
    OutputView.printResultMsg()
    repeat(tryNumber) {
        val result = racing.play()
        OutputView.printResult(result)
    }
}
