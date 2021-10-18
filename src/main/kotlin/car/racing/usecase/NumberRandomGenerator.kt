package car.racing.usecase

import kotlin.random.Random.Default as Random

interface Generator<T> {
    fun generate(): T
}

class NumberRandomGenerator : Generator<Int> {
    override fun generate(): Int {
        return Random.nextInt(MIN_VALUE, MAX_VALUE)
    }

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
    }
}
