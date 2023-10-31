package week1.racingcar

import java.util.Random

object RandomUtils {

    private val random = Random()
    fun getRandomDigit() = random.nextInt(10)
}