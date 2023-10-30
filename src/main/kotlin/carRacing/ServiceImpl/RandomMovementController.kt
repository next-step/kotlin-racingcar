package carRacing.ServiceImpl

import carRacing.Service.MovementController

class RandomMovementController : MovementController {
    override fun isMove(): Boolean = (Math.random() * 10).toInt() >= 4

    override fun getMoveCount(): Int {
        TODO("Not yet implemented")
    }
}
