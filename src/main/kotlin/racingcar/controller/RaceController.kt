package racingcar.controller

import racingcar.domain.CarMovingStrategy
import racingcar.service.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carMovingStrategy = CarMovingStrategy()
    val racing = Race(InputView.numberOfNewCars(), InputView.numberOfMoves())
    racing.confirmMoveOfCars(carMovingStrategy)
    ResultView.carPositionPrints(racing.cars.cars)
}
