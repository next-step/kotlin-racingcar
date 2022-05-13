package fixture

import port.InputSystem

class StubInputSystem(val buffer: List<String>) : InputSystem {

    private var index = 0

    override fun read(): String = buffer[index++]
}
