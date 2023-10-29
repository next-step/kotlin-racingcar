package racingcar

class Car(
    private val name: String = "no name",
) {
    var position: Int = 0
        private set

    fun tryMove(moveCondition: MoveCondition) {
        if (moveCondition.canForward()) {
            position++
        }
    }
}
