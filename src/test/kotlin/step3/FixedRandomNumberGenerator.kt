package step3

class FixedRandomNumberGenerator(private val number: Int) : RandomNumberGenerator {
    override fun generate(): Int = this.number
}
