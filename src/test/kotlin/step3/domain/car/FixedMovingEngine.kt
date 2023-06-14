package step3.domain.car

class FixedMovingEngine(private val defaultMoveDistance: Int = 1) : Engine {
    override fun getMoveDistance(): Int = defaultMoveDistance
}
