package racing.car.util

fun interface RandomGenerator {
    fun generate(): Int
}

class RandomNumberGenerator : RandomGenerator {
    override fun generate(): Int {
        return (0..9).random()
    }
}
