package racing

internal class Car constructor(position: Int = 0) {

    var position: Int = position
        private set

    fun tryMove(movable: Movable) {
        if (movable.isMovable()) {
            this.position++
        }
    }
}
