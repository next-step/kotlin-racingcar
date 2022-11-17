package racing

data class Car(var distance: Int = 0, val moveStrategy: MoveStrategy, val name: Name) {
    fun move() {
        if (moveStrategy.isMovable()) {
            distance += 1
        }
    }
}
