package study.step3.util

import kotlin.random.Random

class RandomDigit : DigitNumber {
    override fun getDigit() = Random.nextInt(0, 10)
}
