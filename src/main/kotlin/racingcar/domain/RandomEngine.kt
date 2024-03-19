package racingcar.domain

import kotlin.random.Random

class RandomEngine: Engine {

    override fun getPower(): Int {
        return Random.nextInt(0, 9)
    }

    companion object {
        const val MIN = 0
        const val MAX = 9
    }
}