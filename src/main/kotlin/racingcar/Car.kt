package racingcar

import java.util.Random

class Car {
    var move = 0
    var viewMove = ""

    fun randomValue(): Int {
        val random = Random()
        return random.nextInt(10)
    }

    fun isGo(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    fun goStop(boolean: Boolean) {
        if (boolean) {
            viewMove += "-"
            move += 1
        }
    }
}
