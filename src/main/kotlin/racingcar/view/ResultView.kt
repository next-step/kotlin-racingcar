package racingcar.view

import racingcar.domain.model.Car
import racingcar.domain.model.InputResult

interface ResultView {
    fun input(): InputResult

    fun printMessage(message: String)

    fun printTurn(turn: Int, cars: List<Car>)

    fun printResult(winner: String)
}
