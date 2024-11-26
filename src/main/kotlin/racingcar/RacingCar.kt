package racingcar

import racingcar.domain.Cars
import racingcar.util.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val usernames = InputView.carNames()
    val round = InputView.roundCount()

    val cars = Cars.from(usernames)
    repeat(round) {
        cars.race(RandomNumberGenerator)
        OutputView.gameResult(cars)
    }

    OutputView.gameWinner(cars)
}
