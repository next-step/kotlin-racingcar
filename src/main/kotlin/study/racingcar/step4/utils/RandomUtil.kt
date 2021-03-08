package study.racingcar.step4.utils

import kotlin.random.Random

class RandomUtil {

    companion object {
        fun getRandomNumberByZeroToMax(maxNumber: Int): Int {
            return Random.nextInt(maxNumber)
        }
    }
}
