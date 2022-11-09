package step3.domain

class DefaultRandomGenerator : RandomGenerator {
    override val candidates: List<Int> = (0..9).toList()
    override fun getRandomNumber(): Int = candidates.random()
    override fun getRandomValidation(): Boolean = getRandomNumber() >= 4
}
