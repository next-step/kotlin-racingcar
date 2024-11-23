package racingcar.model

import kotlin.random.Random

class Forward {
    fun pickRandomNumberInRange(): Int {
        return Random.nextInt(0, 10)
    }
}
