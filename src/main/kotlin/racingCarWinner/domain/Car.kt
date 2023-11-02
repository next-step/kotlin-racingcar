package racingCarWinner.domain

class Car private constructor(
    private val strategy: MoveStrategy,
    val name: String
) {
    var location: Int = 0
        private set

    fun move() {
        if (strategy.isMovable()) {
            forward()
        }
    }

    private fun forward() {
        location += MOVE_CNT
    }

    companion object {
        fun of(strategy: MoveStrategy, name: String): Car {
            return Car(strategy, name)
        }

        private const val MOVE_CNT = 1
    }
}