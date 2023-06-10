package racingcar.util

class RandomNumberGenerator : NumberGenerator {
    override fun getNumber(): Int = (Math.random() * 10).toInt()
}
