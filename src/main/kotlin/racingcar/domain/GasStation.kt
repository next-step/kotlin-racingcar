package racingcar.domain

import kotlin.random.Random

class GasStation {

    fun getRandomGas(): Int {
        return Random.nextInt(from = MIN_VALUE, until = MAX_VALUE)
    }

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
    }
}
