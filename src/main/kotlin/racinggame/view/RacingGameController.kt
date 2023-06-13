package racinggame.view

import racinggame.domain.game.GameGuide
import racinggame.domain.game.GameRule
import racinggame.domain.game.RacingGame
import racinggame.domain.game.RacingGameResult
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

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
            users = List(participantsCount) { index ->
                User(
                    id = UserUniqueId.create(),
                    ordinal = index,
                )
            },
            gameRule = GameRule(gamePlayCount),
        )

        val racingResult = racingGame.execute(gameGuide)
        displayRacingGameResult(racingResult)
    }

    private fun receiveParticipantsCountOrNull(): Int? {
        outputView.display(RacingGameFixedMessage.PARTICIPANTS_INPUT)
        return receivePositiveIntegerFromViewOrNull()
    }

    private fun receiveGamePlayCountOrNull(): Int? {
        outputView.display(RacingGameFixedMessage.GAME_PLAY_COUNT_INPUT)
        return receivePositiveIntegerFromViewOrNull()
    }

    private fun receivePositiveIntegerFromViewOrNull(): Int? {
        return inputView.readLine()
            .toIntOrNull()
            ?.takeIf { it > 0 }
    }

    private fun displayErrorFinishMessage() {
        outputView.display(RacingGameFixedMessage.FINISH_WITH_NOT_POSITIVE_INTEGER)
    }

    private fun displayRacingGameResult(racingGameResult: RacingGameResult) {
        outputView.display(RacingGameFixedMessage.BLANK)
        outputView.display(RacingGameFixedMessage.EXECUTE_RESULT)
        outputView.display(racingGameResult)
    }
}
