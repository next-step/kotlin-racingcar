package racingcar

class Car(
    val id: Int,
    val name: String,
    position: Position = Position(value = 0),
) {
    var position = position
        private set
    fun move(movePolicy: MovePolicy) {
        if (movePolicy.canMove()) {
            this.position = this.position.forward()
        }
    }
}
