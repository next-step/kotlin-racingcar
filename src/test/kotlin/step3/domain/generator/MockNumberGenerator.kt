package step3.domain.generator

class MockNumberGenerator(private val value: Int) : NumberGenerator {

    override fun generate(): Int = value
}
