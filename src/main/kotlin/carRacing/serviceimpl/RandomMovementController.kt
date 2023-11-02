package carRacing.serviceimpl

import carRacing.service.MovementController

class RandomMovementController : MovementController {
    override fun isMove(): Boolean = (Math.random() * 10).toInt() >= 4
}
