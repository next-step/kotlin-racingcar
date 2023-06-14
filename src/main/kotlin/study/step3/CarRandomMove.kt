package study.step3

class CarRandomMove : RandomGenerator {

    override fun randomValue(): Int =
        (MIN_VALUE..MAX_VALUE).random()

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9
    }
}
