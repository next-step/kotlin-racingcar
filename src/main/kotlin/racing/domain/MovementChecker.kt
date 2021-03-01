package racing.domain

import racing.domain.random.RandomWrapper
import racing.domain.random.DefaultRandomWrapper

class MovementChecker(private val randomWrapper: RandomWrapper = DefaultRandomWrapper()) {

    fun isMovable() = randomWrapper.nextInt(MAX_RANDOM_NUMBER_PLUS_ONE) >= MIN_RANDOM_NUMBER_MOVABLE

    companion object {
        const val MAX_RANDOM_NUMBER_PLUS_ONE = 10
        const val MIN_RANDOM_NUMBER_MOVABLE = 4
    }
}
