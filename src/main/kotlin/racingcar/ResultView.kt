package racingcar

import racingcar.domain.Cars

interface ResultView {
    fun showTitle()
    fun showStatuses(cars: Cars)
}
