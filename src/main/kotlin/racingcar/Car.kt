package racingcar

data class Car(
    private val moveCondition: MoveCondition,
    val name: String = "no name",
    val position: Int = 0,
) {
    fun tryMove(): Car {
        if (moveCondition.canForward()) {
            return copy(position = position + 1)
        }

        return this
    }
}
