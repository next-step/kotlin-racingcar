package racing.utils

import racing.port.RandomGeneratorPort
import kotlin.random.Random

class RandomGenerator(private val from: Int, private val until: Int) : RandomGeneratorPort {

    override fun generate(): Int = Random.nextInt(from, until)
}
