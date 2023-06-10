package step3.domain

import kotlin.random.Random

object RandomGenerator {
    fun next0To9(): Int {
        return Random.nextInt(0, 10)
    }
}
