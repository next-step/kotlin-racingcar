package racing

class Car(
    var position: Int = 0
) {
    fun move(movePolicy: MovePolicy) {
        if (movePolicy.isMovable()) {
            position += 1
        }
    }
}
