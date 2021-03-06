package racingcar.game.domain

import racingcar.game.vo.GameParameter
import racingcar.game.vo.GameResult
import racingcar.game.vo.GameRoundResult

const val MIN_MOVE_CONDITION = 0
const val MAX_MOVE_CONDITION = 9

class Game(private val inputParameter: GameParameter) {
    fun start(): GameResult {
        val participant = Participant(inputParameter.numOfCar!!.toInt())
        val result = arrayListOf<GameRoundResult>()

        repeat(inputParameter.numOfGame!!.toInt()) {
            participant.cars.forEach { it.move(generateMoveCondition()) }
            addResult(result, participant)
        }

        return GameResult(result)
    }

    private fun generateMoveCondition(): Int = (MIN_MOVE_CONDITION..MAX_MOVE_CONDITION).random()

    private fun addResult(
        result: ArrayList<GameRoundResult>,
        participant: Participant
    ) {
        result.add(GameRoundResult(participant.cars.map { it.position.copy() }.toList()))
    }
}
