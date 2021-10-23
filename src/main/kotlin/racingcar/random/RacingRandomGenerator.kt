package racingcar.random

class RacingRandomGenerator : RandomGenerator {
    override fun randomNum(max: Int): Int = (0..max).random()
}
