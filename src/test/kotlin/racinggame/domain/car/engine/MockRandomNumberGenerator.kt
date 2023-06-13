package racinggame.domain.car.engine

class MockRandomNumberGenerator(
    private val fixedRandomNumber: Int,
) : RandomNumberGenerator {

    override fun generate(range: IntRange): Int {
        return fixedRandomNumber
    }
}
