package racing.domain

import racing.domain.random.DefaultRandomWrapper
import racing.domain.random.RandomWrapper

class MovementChecker(private val randomWrapper: RandomWrapper = DefaultRandomWrapper()) {

    fun isMovable(): Boolean = randomWrapper.nextInt(MAX_RANDOM_NUMBER_PLUS_ONE) >= MIN_RANDOM_NUMBER_MOVABLE

    companion object {
        const val MAX_RANDOM_NUMBER_PLUS_ONE = 10
        const val MIN_RANDOM_NUMBER_MOVABLE = 4
    }
}
