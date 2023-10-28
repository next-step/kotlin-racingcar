package study.racingcar

import kotlin.random.Random
import kotlin.random.nextInt

class Car(position: Int = 0) {
    var position = position
        private set

    fun move(randomValue: Int = Random.nextInt(0..10)) {
        if (randomValue >= 4) {
            position += 1
        }
    }

    fun displayPosition(): String = "-".repeat(position)
}
