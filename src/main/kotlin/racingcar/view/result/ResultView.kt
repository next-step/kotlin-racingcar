package racingcar.view.result

import racingcar.domain.Cars

interface ResultView {
    fun showTitle()
    fun showStatuses(cars: Cars)
    fun showWinners(cars: Cars)
}
