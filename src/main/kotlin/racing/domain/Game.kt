package racing.domain

import racing.domain.strategy.RandomMovingStrategy
import racing.view.GameOutputView

class Game(racingCarCount: Int = 2, private val round: Int = 3) {
    var cars = List(racingCarCount) { Car(MOVING_STRATEGY) }

    fun play() {
        gameOutputView.startGame()
        for (i in 0 until round) {
            race()
            gameOutputView.printRaceStatus(cars)
            gameOutputView.nextRound()
        }
    }

    private fun race() {
        cars.forEach {
            it.move()
        }
    }

    companion object {
        private val MOVING_STRATEGY = RandomMovingStrategy()
        private val gameOutputView = GameOutputView()
    }
}
