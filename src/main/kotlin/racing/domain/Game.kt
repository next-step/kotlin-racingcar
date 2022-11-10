package racing.domain

import racing.domain.strategy.RandomMovingStrategy
import racing.view.GameOutputView

object Game {

    fun play(racingCarCount: Int = 2, round: Int = 3) {

        val cars = List(racingCarCount) { Car(RandomMovingStrategy) }

        GameOutputView.printStartGame()
        repeat(round) {
            cars.forEach {
                it.move()
            }
            GameOutputView.printRaceStatus(cars)
            GameOutputView.printNextRound()
        }
    }
}
