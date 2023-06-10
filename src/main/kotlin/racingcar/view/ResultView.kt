package racingcar.view

import racingcar.model.Car
import racingcar.model.InputResult

interface ResultView {
    fun input(): InputResult

    fun printMessage(message: String)

    fun output(turn: Int, cars: List<Car>)
}
