package racingcar.interfaces.ui.input

import racingcar.application.port.`in`.InputPort
import racingcar.interfaces.ui.input.console.RacingCarInputConsole

class RacingCarInputView(
    private val inputPort: InputPort
) {

    fun input() {
        val input = RacingCarInputConsole.input()
        inputPort.input(input)
    }
}
