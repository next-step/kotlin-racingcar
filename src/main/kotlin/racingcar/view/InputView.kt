package racingcar.view

import racingcar.domain.Position
import racingcar.domain.RacingCar
import racingcar.domain.Round

object InputView {

    private const val RACING_CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?"
    private const val MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?"

    fun readRacingCars(): List<RacingCar> {
        println(RACING_CAR_COUNT_QUESTION)
        return List(readln().toInt()) { RacingCar(Position(0)) }
    }

    fun readGameRound(): Round {
        println(MOVE_COUNT_QUESTION)
        return Round(readln().toInt())
    }
}
