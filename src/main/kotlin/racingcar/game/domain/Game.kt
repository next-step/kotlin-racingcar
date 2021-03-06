package racingcar.game.domain

import racingcar.game.vo.GameParameter
import racingcar.game.vo.GameResult
import racingcar.game.vo.GameRoundResult

const val MIN_MOVE_CONDITION = 0
const val MAX_MOVE_CONDITION = 9

fun generateMoveCondition(): Int = (MIN_MOVE_CONDITION..MAX_MOVE_CONDITION).random()

class Game(private val inputParameter: GameParameter, private val moveCondition: () -> Int) {
    fun start(): GameResult {
        val participant = Participant(inputParameter.nameOfCar)
        val result = mutableListOf<GameRoundResult>()
        repeat(inputParameter.numOfGame) {
            participant.cars.forEach { it.move(moveCondition()) }
            result.add(participant.getRoundResult())
        }

        return GameResult(result)
    }
}
