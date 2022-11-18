package racingcar.interfaces.ui.input

import racingcar.application.port.input.InputPort
import racingcar.interfaces.ui.input.console.RacingCarInputConsole

class RacingCarInputAdapter(
    private val inputPort: InputPort
) {

    fun input() {
        val input = RacingCarInputConsole.input()
        inputPort.input(input)
    }
}
