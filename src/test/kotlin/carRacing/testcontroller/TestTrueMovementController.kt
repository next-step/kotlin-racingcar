package carRacing.testcontroller

import carRacing.service.MovementController

class TestTrueMovementController : MovementController {
    override fun isMove(): Boolean = true
}
