package racingcar.domain

data class Car(
    val name: CarName,
    private val moveStrategy: MoveStrategy,
    private val moveDepth: Int = 1,
    val distance: Int = 0
) {

    fun moveIfMoveable(): Car {
        if (moveStrategy.isMoveable()) {
            val movedDistance = distance + moveDepth
            return copy(distance = movedDistance)
        }
        return this
    }
}
