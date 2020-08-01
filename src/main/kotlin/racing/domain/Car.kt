package racing.domain

import racing.infrastructure.RacingGame
import kotlin.random.Random

typealias Cars = List<Car>

class Car(val name: String = "", var distance: Int = 0) {

    fun makeCars(names: List<String>): Cars {
        return names.map { name -> Car(name) }
    }

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
