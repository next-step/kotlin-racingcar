package racing.domain

import racing.infrastructure.RacingGame
import kotlin.random.Random

class Car(val name: String = "", var distance: Int = 0) {

    fun move() {
        if (canIMove()) {
            distance++
        }
    }

    fun canIMove(): Boolean {
        val random = Random.nextInt(
            RacingGame.MINIMUM_RANGE_NUMBER,
            RacingGame.MAXIMUM_RANGE_NUMBER
        )
        if (random >= RacingGame.MOVE_CONDITION_NUMBER) {
            return true
        }
        return false
    }
}
