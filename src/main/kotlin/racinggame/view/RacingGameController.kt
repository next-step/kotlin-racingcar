package racinggame.view

import racinggame.domain.car.CarName
import racinggame.domain.car.toCarNames
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
        val carNames = receiveCarNamesOrNull() ?: run {
            outputView.display(RacingGameFixedMessage.FINISH_WITH_INVALID_NAME)
            return
        }

        val gamePlayCount = receiveGamePlayCountOrNull() ?: run {
            outputView.display(RacingGameFixedMessage.FINISH_WITH_NOT_POSITIVE_INTEGER)
            return
        }

        val gameGuide = GameGuide(
            users = carNames.mapIndexed { index, carName ->
                User(
                    id = UserUniqueId.create(),
                    carName = carName,
                    ordinal = index,
                )
            },
            gameRule = GameRule(gamePlayCount),
        )

        val racingResult = racingGame.execute(gameGuide)
        displayRacingGameResult(racingResult)
    }

    private fun receiveCarNamesOrNull(): List<CarName>? {
        outputView.display(RacingGameFixedMessage.CAR_NAMES_INPUT)
        return inputView.readLine()
            .split(USER_NAMES_DELIMITER)
            .let { inputNames -> runCatching { inputNames.toCarNames() } }
            .getOrNull()
    }

    private fun receiveGamePlayCountOrNull(): Int? {
        outputView.display(RacingGameFixedMessage.GAME_PLAY_COUNT_INPUT)
        return inputView.readLine()
            .toIntOrNull()
            ?.takeIf { it > 0 }
    }

    private fun displayRacingGameResult(racingGameResult: RacingGameResult) {
        outputView.display(RacingGameFixedMessage.BLANK)
        outputView.display(RacingGameFixedMessage.EXECUTE_RESULT)
        outputView.display(racingGameResult)
    }

    companion object {

        private const val USER_NAMES_DELIMITER = ","
    }
}
