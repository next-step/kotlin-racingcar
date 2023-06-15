package racinggame.view

import racinggame.domain.car.CarName
import racinggame.domain.game.GameGuide
import racinggame.domain.game.GameRule
import racinggame.domain.game.RacingGame
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RacingGameController(
    private val inputView: RacingGameInputView,
    private val resultView: RacingGameResultView,
    private val racingGame: RacingGame,
) {

    fun start() {
        val gameGuide = inputView.readRacingGameInput()
            .getOrNull()
            ?.let { racingGameInput -> makeGameGuide(racingGameInput) }
            ?: return

        val racingResult = racingGame.execute(gameGuide)
        resultView.display(racingResult)
    }

    private fun makeGameGuide(racingGameInput: RacingGameInput): GameGuide {
        return GameGuide(
            users = makeUsers(racingGameInput.carNames),
            gameRule = GameRule(racingGameInput.gamePlayCount),
        )
    }

    private fun makeUsers(carNames: List<CarName>): List<User> {
        return carNames.mapIndexed { index, carName ->
            User(
                id = UserUniqueId.create(),
                carName = carName,
                ordinal = index,
            )
        }
    }
}
