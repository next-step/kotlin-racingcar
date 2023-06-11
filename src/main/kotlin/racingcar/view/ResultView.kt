package racingcar.view

import racingcar.model.Car

interface ResultView {
    fun input(): Pair<Int, Int>

    fun output(carList: List<Car>)
}
