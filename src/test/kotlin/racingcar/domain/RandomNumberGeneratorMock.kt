package racingcar.domain

class RandomNumberGeneratorMock(
    private val number: Int,
) : RandomNumberGenerator {
    override fun getNumber(): Int = number
}
