package racingcar.interfaces.ui.output

import racingcar.interfaces.ui.output.console.RacingCarOutputConsole

class RacingCarOutputAdapter {
    fun output(string: String) {
        RacingCarOutputConsole.consolePrint(string)
    }
}
