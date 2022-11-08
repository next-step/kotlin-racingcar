package racing.domain

import racing.domain.strategy.RandomMovingStrategy

data class Game(val team: Int, val round: Int) {
    companion object {
        private val RANDOM_STRATEGY = RandomMovingStrategy()
    }

    val cars = List(team) { Car(RANDOM_STRATEGY) }
}
