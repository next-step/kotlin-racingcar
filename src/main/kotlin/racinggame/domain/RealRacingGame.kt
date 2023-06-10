package racinggame.domain

import racinggame.domain.car.RacingCar
import racinggame.domain.car.factory.RacingCarFactory
import racinggame.domain.car.getOffAllRacer
import racinggame.domain.employee.GameGuide
import racinggame.domain.player.User
import racinggame.domain.player.toRacer

class RealRacingGame(
    private val racingCarFactory: RacingCarFactory,
) : RacingGame {

    override fun execute(gameGuide: GameGuide) {
        val racingCars = gameGuide.users.getInRacingCars()
        // execute game
        racingCars.getOffAllRacer()
    }

    private fun List<User>.getInRacingCars(): List<RacingCar> {
        return map { user -> user.toRacer() }
            .map { racer -> racingCarFactory.create().apply { getIn(racer) } }
    }
}
