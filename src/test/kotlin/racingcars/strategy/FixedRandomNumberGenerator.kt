package racingcars.strategy

class FixedRandomNumberGenerator(private val number: Int) : RandomNumberGenerator {
    override fun generate(): Int = this.number
}
