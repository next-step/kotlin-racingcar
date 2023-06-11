package racingcar.domain

import kotlin.random.Random

class RandomNumberGenerator(
    private val randomBase: Long,
    private val randomLimit: Long,
) {

    fun generate(): Long {
        return Random.nextLong(randomBase, randomLimit + 1)
    }
}
