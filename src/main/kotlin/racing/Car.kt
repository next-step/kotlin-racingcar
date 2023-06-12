package racing

class Car(
    val name: String,
    var position: Int = 0,
) {
    fun move(movePolicy: MovePolicy) {
        if (movePolicy.isMovable()) {
            position += 1
        }
    }
}
