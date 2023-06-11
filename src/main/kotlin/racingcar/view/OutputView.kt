package racingcar.view

import racingcar.domain.Cars

interface OutputView {
    fun printCarsPosition(cars: Cars)
}
