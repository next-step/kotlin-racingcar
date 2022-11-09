package study.step4.util

import kotlin.random.Random

class RandomDigit : DigitGenerator {
    override fun getDigit() = Random.nextInt(0, 10)
}
