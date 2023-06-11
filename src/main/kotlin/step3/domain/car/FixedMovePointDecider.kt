package step3.domain.car

class FixedMovePointDecider(private val defaultMovePoint: Int = 1) : CarMovePointDecider {
    override fun getMovePoint(): Int = defaultMovePoint
}
