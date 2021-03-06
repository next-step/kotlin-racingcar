package racingcar.game.domain

import racingcar.game.vo.GameParameter
import racingcar.game.vo.GameResult

const val MIN_MOVE_CONDITION = 0
const val MAX_MOVE_CONDITION = 9

object Game {
    fun start(
        inputParameter: GameParameter,
        moveCondition: () -> Int = { generateMoveCondition() }
    ): GameResult {
        val participant = Participant(inputParameter.nameOfCars)

        repeat(inputParameter.numOfGame) {
            participant.moveCars(moveCondition)
            participant.setRoundResult()
        }

        return GameResult(participant.gameResult)
    }

    fun generateMoveCondition(): Int = (MIN_MOVE_CONDITION..MAX_MOVE_CONDITION).random()
}
