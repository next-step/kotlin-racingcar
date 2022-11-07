package step3.domain.game.history

import step3.domain.RacingGame
import step3.domain.car.RacingCar

class RacingGameHistory(racingGame: RacingGame) {

    val history: List<RacingCar> = racingGame.carList.map { it.clone() }.toList()

    override fun toString(): String {
        return "[${this.javaClass.simpleName}(history=$history]"
    }

    private fun RacingCar.clone(): RacingCar {
        val racingCar = RacingCar(name)
        racingCar.distance = distance
        return racingCar
    }
}
