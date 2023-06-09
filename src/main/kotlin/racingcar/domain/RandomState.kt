package racingcar.domain

class RandomState : MoveState {
    private val range: IntRange = 0..9
    private val condition = 4

    override val isMovable: Boolean
        get() = randomInt >= condition

    val randomInt: Int
        get() = range.random()
}
