package racing.game

import racing.car.RacingCar
import racing.condition.MovingCondition
import racing.view.ResultView

class RacingGame {

    private val racingCar: MutableList<RacingCar> = mutableListOf()

    fun racingGameCarInit(carCount: Int): List<RacingCar> {
        repeat(carCount) {
            racingCar.add(RacingCar())
        }
        return racingCar
    }

    fun executeGame(retryCount: Int, racingCars: List<RacingCar>) {
        repeat(retryCount) {
            racingCars.forEach {
                if (MovingCondition().getRandomValue() >= 4) {
                    it.move()
                }
            }
            ResultView().showGameBoard(racingCars)
        }
    }
}
