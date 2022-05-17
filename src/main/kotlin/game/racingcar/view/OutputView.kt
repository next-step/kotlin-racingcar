package game.racingcar.view

import game.racingcar.domain.Car

interface OutputView {
    fun getResult(cars: List<Car>, winners: List<Car>): String
}
