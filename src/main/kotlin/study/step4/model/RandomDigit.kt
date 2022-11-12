package study.step4.model

import kotlin.random.Random

class RandomDigit : DigitGenerator {
    override fun getDigit() = Random.nextInt(0, 10)
}
