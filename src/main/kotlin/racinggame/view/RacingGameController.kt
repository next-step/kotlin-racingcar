package racinggame.view

import racinggame.domain.RacingGame
import racinggame.domain.RacingGameResult
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

        outputView.display(RacingGameFixedMessage.BLANK)

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
        outputView.display(RacingGameFixedMessage.EXECUTE_RESULT)

        racingGameResult.racingRecordBook
            .totalRacingRecordPaperList
            .forEach {racingRecordPaperList ->
                racingRecordPaperList.list
                    .map { racingRecordPaper -> RacingCarMoveDistance(racingRecordPaper.moveDistance.distance) }
                    .forEach { racingCarMoveDistance -> outputView.display(racingCarMoveDistance) }

                outputView.display(RacingGameFixedMessage.BLANK)
        }
    }
}
