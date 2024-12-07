package racingcar.car

import kotlin.random.Random

object RandomMachine {
    fun getRandomNumber(): Int {
        val randomNumber = Random.nextInt(0, 10)
        return if (randomNumber >= 4) randomNumber else 0
    }
}
