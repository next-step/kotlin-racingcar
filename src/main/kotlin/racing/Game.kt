package racing

import racing.domain.Car
import racing.domain.RandomStrategy

data class Game(val team: Int, val round: Int) {
    companion object {
        private val RANDOM_STRATEGY = RandomStrategy()
    }

    val cars = List(team) { Car(RANDOM_STRATEGY) }
}
