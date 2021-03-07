package racing.domain

class StaticMovable(private val movable: Boolean) : Movable {
    override fun isMovable(): Boolean {
        return movable
    }
}
