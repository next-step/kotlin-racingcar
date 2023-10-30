package study.racingcar

import study.racingcar.inteface.RandomMoveStrategy
import study.racingcar.service.Race
import study.racingcar.ui.InputView

fun main() {
    val carNames = InputView.getCarNames()
    val moveCount = InputView.getMoveCount()
    val randomMoveStrategy = RandomMoveStrategy()
    Race.createWithCarNames(carNames, moveCount, randomMoveStrategy).run()
}
