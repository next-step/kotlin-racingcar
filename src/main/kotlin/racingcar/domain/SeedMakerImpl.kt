package racingcar.domain

import kotlin.random.Random

class SeedMakerImpl : SeedMaker {
    override fun nextInt(): Int = Random.nextInt(DEFAULT_RANDOM_RANGE)

    companion object {
        private const val DEFAULT_RANDOM_RANGE = 10
    }
}
