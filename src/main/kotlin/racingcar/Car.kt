package racingcar

import java.util.Random

class Car {
    val move = 0
    val viewMove = ""

    fun randomValue(): Int {
        val random = Random()
        return random.nextInt(10)
    }

    fun isGo(randomNum: Int): Boolean {
        return randomNum >= 4
    }
}
