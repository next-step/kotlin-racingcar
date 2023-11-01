package carRacing.testcontroller

import carRacing.service.MovementController

class TestFalseMovementController : MovementController {
    override fun isMove(): Boolean = false

    override fun getMoveCount(): Int {
        TODO("Not yet implemented")
    }
}
