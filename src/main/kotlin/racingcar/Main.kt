package racingcar

import InputView
import racingcar.domain.Racing
import racingcar.strategy.RandomStrategy
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.getCarNames()
    val tryCount = InputView.getTryCount()
    val racingCar = Racing(carNames, tryCount, RandomStrategy())
    while (racingCar.isProgress()) {
        val distances = racingCar.race()
        ResultView.viewDistances(distances)
    }
    val winners = racingCar.getWinner()
    ResultView.viewWinner(winners)
}
