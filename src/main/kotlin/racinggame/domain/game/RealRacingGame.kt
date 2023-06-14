package racinggame.domain.game

import racinggame.domain.car.RacingCar
import racinggame.domain.car.factory.RacingCarFactory
import racinggame.domain.field.RacingField
import racinggame.domain.player.User
import racinggame.domain.record.RacingHistoryRecoder

class RealRacingGame(
    private val racingCarFactory: RacingCarFactory,
) : RacingGame {

    override fun execute(gameGuide: GameGuide): RacingGameResult {
        return startRacingGame(
            racingCars = gameGuide.users.assignUsersToRacingCars(),
            gameRule = gameGuide.gameRule,
        )
    }

    private fun List<User>.assignUsersToRacingCars(): List<RacingCar> {
        return map { user -> racingCarFactory.create(user) }
    }

    private fun startRacingGame(
        racingCars: List<RacingCar>,
        gameRule: GameRule,
    ): RacingGameResult {
        val racingHistoryRecoder = RacingHistoryRecoder()

        val racingField = RacingField().apply {
            ready(racingCars)
        }
        repeat(gameRule.playCount) {
            racingField.publishGoSignal()
            racingHistoryRecoder.capture(racingField)
        }
        racingField.clear()

        return RacingGameResult(
            racingRecordBook = racingHistoryRecoder.createBook(),
        )
    }
}
