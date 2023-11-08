package racing.v2.domain

class FixedNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate(upperBound: Int): Int = this.number
}
