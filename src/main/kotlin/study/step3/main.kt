package study.step3

import study.step3.inteface.RandomMoveStrategy
import study.step3.racing.Race
import study.step3.ui.InputView

fun main() {
    val carCount = InputView.getCarCount()
    val moveCount = InputView.getMoveCount()
    val randomMoveStrategy = RandomMoveStrategy()
    Race(carCount, moveCount, randomMoveStrategy).run()
}
