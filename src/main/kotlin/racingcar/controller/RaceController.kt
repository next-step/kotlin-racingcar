package racingcar.controller

import racingcar.domain.RandomCarMovingStrategy
import racingcar.service.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val racing = Race(InputView.nameOfNewCars(), InputView.numberOfMoves())
    racing.confirmMoveOfCars(RandomCarMovingStrategy)
    ResultView.carPositionPrints(racing.cars.cars)
}
