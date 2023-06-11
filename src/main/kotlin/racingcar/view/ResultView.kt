package racingcar.view

import racingcar.model.Car
import racingcar.model.InputResult

interface ResultView {
    fun input(): InputResult

    fun output(turn: Int, carList: List<Car>)
}
