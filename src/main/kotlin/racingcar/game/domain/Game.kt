package racingcar.game.domain

import racingcar.game.vo.GameParameter

const val MIN_MOVE_CONDITION = 0
const val MAX_MOVE_CONDITION = 9

object Game {
    fun start(
        inputParameter: GameParameter,
        moveCondition: () -> Int = { defaultMoveCondition() }
    ): GameResult {

        val participant = Participant(inputParameter.nameOfCars)
        val result = GameResult()

        repeat(inputParameter.numOfGame) {
            val gameRoundResult = participant.moveCars(moveCondition)
            result.recordGameRoundHistory(gameRoundResult)
        }

        return result
    }

    private fun defaultMoveCondition(): Int = (MIN_MOVE_CONDITION..MAX_MOVE_CONDITION).random()
}
