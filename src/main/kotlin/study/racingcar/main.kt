package study.racingcar

import study.racingcar.domain.Car
import study.racingcar.domain.CarName
import study.racingcar.domain.Race
import study.racingcar.inteface.RandomMoveStrategy
import study.racingcar.ui.InputView
import study.racingcar.ui.ResultView

fun main() {
    val carNameStrings = InputView.getCarNames()
    val carNames = carNameStrings.map { CarName(it) }
    val cars = carNames.map { Car(it) }
    val moveCount = InputView.getMoveCount()
    val randomMoveStrategy = RandomMoveStrategy()
    val race = Race.create(cars, moveCount, randomMoveStrategy)
    val raceResult = race.run()
    ResultView.displayCars(raceResult)
    ResultView.displayWinners(race)
}
