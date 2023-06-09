package racingcar.domain

class RandomCondition : MoveCondition {
    private val range: IntRange = 0..9
    private val condition = 4

    override fun isMovable(): Boolean {
        return randomInt >= condition
    }

    val randomInt: Int
        get() = range.random()
}
