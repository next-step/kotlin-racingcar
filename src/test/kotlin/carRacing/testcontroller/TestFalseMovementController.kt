package carRacing.testcontroller

import carRacing.service.MovementController

class TestFalseMovementController : MovementController {
    override fun isMove(): Boolean = false
}
