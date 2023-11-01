package racing_car

import kotlin.random.Random

class Car {

    var position = 0
        private set

    fun move() {
        val randomInt = Random.nextInt(0, 10)
        if (randomInt >= 4) {
            position++
        }
    }
}
