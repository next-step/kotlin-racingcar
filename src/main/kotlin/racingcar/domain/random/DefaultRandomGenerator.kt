package racingcar.domain.random

class DefaultRandomGenerator : RandomGenerator {
    private fun getRandomNumber(): Int = (0..9).random()
    override fun getRandomValidation(): Boolean = getRandomNumber() >= 4
}
