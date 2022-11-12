package racingcar

data class Car(
    val id: Int,
    val name: String,
    val currentPosition: Int = 0,
) {
    fun move(moveStrategy: MoveStrategy): Car {
        return when (moveStrategy.isPossibleMove()) {
            true -> this.copy(currentPosition = currentPosition + moveStrategy.getDistance())
            false -> this
        }
    }
}
