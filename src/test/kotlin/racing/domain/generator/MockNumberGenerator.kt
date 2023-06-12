package racing.domain.generator

class MockNumberGenerator(private val value: Int) : NumberGenerator {

    override fun generate(): Int = value
}
