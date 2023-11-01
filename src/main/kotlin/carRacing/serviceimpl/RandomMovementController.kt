package carRacing.serviceimpl

import carRacing.service.MovementController

class RandomMovementController : MovementController {
    override fun isMove(): Boolean = (Math.random() * 10).toInt() >= 4

    override fun getMoveCount(): Int {
        TODO("Not yet implemented")
    }
}
