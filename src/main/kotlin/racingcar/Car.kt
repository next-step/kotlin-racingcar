package racingcar

import kotlin.random.Random

class Car(
    val name: String,
    private var moveCount: Int = 0,
) : Displayable {
    fun move() {
        if (Random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD) {
            moveCount++
        }
    }

    fun getMoveCount() : Int = moveCount

    override fun display(): String = "$name : " + "-".repeat(moveCount)

    companion object {
        private const val MOVE_THRESHOLD = 4
        private const val RANDOM_RANGE = 10
        private const val NAME_RANGE = 5

        fun create(name: String): Car {
            validName(name)
            return Car(name)
        }

        fun getMoveThreshold() = MOVE_THRESHOLD
        fun getRandomRange() = RANDOM_RANGE
        fun getNameRange() = NAME_RANGE

        private fun validName(name: String) {
            if (name.length > NAME_RANGE) {
                throw IllegalArgumentException("{$name}의 길이는 ${NAME_RANGE}를 초과할 수 없습니다.")
            }
        }
    }
}
