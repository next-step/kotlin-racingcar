package racingcar

class Car(
    val moveCondition: MoveCondition,
    val name: String = "no name",
) {
    var position: Int = 0
        private set

    fun tryMove() {
        if (moveCondition.canForward()) {
            position++
        }
    }
}
