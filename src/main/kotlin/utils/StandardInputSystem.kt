package utils

import port.InputSystem

class StandardInputSystem : InputSystem {

    override fun read(): String {
        return readln()
    }
}
