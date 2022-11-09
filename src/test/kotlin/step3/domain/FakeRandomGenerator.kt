package step3.domain

class FakeRandomGenerator : RandomGenerator {
    override val candidates: List<Int> = (0..9).toList()

    override fun getRandomNumber(): Int = candidates[4]

    var isValid: Boolean = true

    override fun getRandomValidation(): Boolean = isValid
}
