package racing

open class Moving(private var movable: Movable) {
    fun canMove(): Boolean = movable.canMove()

    fun setMovable(movable: Movable) {
        this.movable = movable
    }
}
