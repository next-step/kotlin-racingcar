package racing.v2.domain

class FakeCarGameRandomGenerator(private val number: Int) : RandomGenerator {
    override fun nextInt(upperBound: Int): Int = this.number
}
