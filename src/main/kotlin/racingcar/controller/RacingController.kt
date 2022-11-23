package racingcar.controller

import racingcar.domain.Racing
import racingcar.domain.RandomStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

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
    val winners = racing.pickWinner()
    OutputView.printWinners(winners)
}
