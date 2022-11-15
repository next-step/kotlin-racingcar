package step3

class Car(
    val id: Int,
    val name: String,
) {
    var position = Position(value = 0)
        private set
    fun move(movePolicy: MovePolicy) {
        if (movePolicy.canMove()) {
            this.position = this.position.forward()
        }
    }
}
