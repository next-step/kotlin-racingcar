package racinggame.domain

import racinggame.domain.car.RacingCar
import racinggame.domain.car.factory.RacingCarFactory
import racinggame.domain.car.getOffAllRacer
import racinggame.domain.employee.GameGuide
import racinggame.domain.employee.GameRule
import racinggame.domain.employee.RacingHistoryRecoder
import racinggame.domain.field.RacingField
import racinggame.domain.player.User
import racinggame.domain.player.toRacer
import racinggame.domain.record.RacingRecordBook

class RealRacingGame(
    private val racingCarFactory: RacingCarFactory,
) : RacingGame {

    override fun execute(gameGuide: GameGuide): RacingGameResult {
        val racingCars = gameGuide.users.getInRacingCars()
        val racingRecordBook = startRacingGame(
            racingCars = racingCars,
            gameRule = gameGuide.gameRule,
        )
        racingCars.getOffAllRacer()

        return RacingGameResult(
            racingRecordBook = racingRecordBook,
        )
    }

    private fun List<User>.getInRacingCars(): List<RacingCar> {
        return mapIndexed { index, user -> user.toRacer(ordinal = index) }
            .map { racer -> racingCarFactory.create().apply { getIn(racer) } }
    }

    private fun startRacingGame(
        racingCars: List<RacingCar>,
        gameRule: GameRule,
    ): RacingRecordBook {
        val racingHistoryRecoder = RacingHistoryRecoder()

        val racingField = RacingField().apply {
            ready(racingCars)
        }
        repeat(gameRule.playCount) {
            racingField.publishGoSignal()
            racingHistoryRecoder.capture(racingField)
        }
        racingField.clear()

        return racingHistoryRecoder.createBook()
    }
}
