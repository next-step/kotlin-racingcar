package racinggame.view

import racinggame.domain.RacingGame
import racinggame.domain.employee.GameGuide
import racinggame.domain.employee.GameRule
import racinggame.domain.player.User

class RacingGameController(
    private val inputView: RacingGameInputView,
    private val outputView: RacingGameOutputView,
    private val racingGame: RacingGame,
) {

    fun start() {
        val participantsCount = receiveParticipantsCountOrNull() ?: run {
            displayErrorFinishMessage()
            return
        }

        val gamePlayCount = receiveGamePlayCountOrNull() ?: run {
            displayErrorFinishMessage()
            return
        }

        val gameGuide = GameGuide(
            users = List(participantsCount) { index -> User(id = index.toString()) },
            gameRule = GameRule(gamePlayCount),
        )

        racingGame.execute(gameGuide)
    }

    private fun receiveParticipantsCountOrNull(): Int? {
        outputView.displayMessage(RacingGameMessage.PARTICIPANTS_INPUT)
        return receivePositiveIntegerFromViewOrNull()
    }

    private fun receiveGamePlayCountOrNull(): Int? {
        outputView.displayMessage(RacingGameMessage.GAME_PLAY_COUNT_INPUT)
        return receivePositiveIntegerFromViewOrNull()
    }

    private fun receivePositiveIntegerFromViewOrNull(): Int? {
        return inputView.readLine()
            .toIntOrNull()
            ?.takeIf { it > 0 }
    }

    private fun displayErrorFinishMessage() {
        outputView.displayMessage(RacingGameMessage.FINISH_WITH_NOT_POSITIVE_INTEGER)
    }
}
