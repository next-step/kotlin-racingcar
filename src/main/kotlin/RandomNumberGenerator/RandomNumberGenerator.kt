package game.randomnumbergenerator

import kotlin.random.Random

interface RandomNumberGenerator {
    fun generate(): Int
}

class RealRandomNumberGenerator : RandomNumberGenerator {
    companion object {
        val from: Int = 0
        val to: Int = 9
    }

    override fun generate(): Int = Random.nextInt(from, to + 1)

}
