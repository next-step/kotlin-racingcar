package racingcar

import racingcar.race.Race
import racingcar.view.InputView

class GameBoard(minCarCount: Int = 1, minMoveCount: Int = 1) {
    private val inputView = InputView(minCarCount, minMoveCount)
    private val race = Race(inputView.carCount, inputView.moveCount)
    val cars = race.cars
    val stepSize = race.railSize
}
