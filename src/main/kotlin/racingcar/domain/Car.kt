package racingcar.domain

import kotlin.random.Random

class Car {
    var position: Int = 0
        private set

    fun move(condition: Int) {
        if (Random.nextInt(10) >= condition) {
            position++
        }
    }
}
