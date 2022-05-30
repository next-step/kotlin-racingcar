package racingcar.view

import racingcar.domain.Cars

interface OutputView {
    fun printCarPositions(cars: Cars)
}
