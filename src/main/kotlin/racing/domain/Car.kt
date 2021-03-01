package racing.domain

private const val DEFAULT_POSITION = 0

internal class Car(position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    fun tryMove(movable: Movable) {
        if (movable.isMovable()) {
            this.position++
        }
    }
}
