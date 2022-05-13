package racing.utils

import racing.port.InputSystem

class StandardInputSystem : InputSystem {

    override fun read(): String {
        return readln()
    }
}
