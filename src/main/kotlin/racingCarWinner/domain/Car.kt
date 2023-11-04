package racingCarWinner.domain

class Car private constructor(
    val name: String,
    private val strategy: MoveStrategy
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
        fun of(name: String, strategy: MoveStrategy = RandomMoveStrategy): Car {
            return Car(name, strategy)
        }

        private const val MOVE_CNT = 1
    }
}