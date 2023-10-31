package racingcar

import kotlin.random.Random

class Car(
    private var moveCount: Int = 0,
) : Displayable {
    fun move() {
        if (Random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD) {
            moveCount++
        }
    }

    override fun display(): String = "-".repeat(moveCount)

    companion object {
        private const val MOVE_THRESHOLD = 4
        private const val RANDOM_RANGE = 10

        fun create(): Car = Car()

        fun getMoveThreshold() = MOVE_THRESHOLD
        fun getRandomRange() = RANDOM_RANGE
    }
}
