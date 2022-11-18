package racingcar.application.port.output

import racingcar.interfaces.ui.output.RacingCarOutputAdapter

class OutputPort(
    private val racingCarOutputAdapter: RacingCarOutputAdapter
) {

    fun output(stringCommand: String) {
        return racingCarOutputAdapter.output(stringCommand)
    }

    fun outputNewLine() {
        return racingCarOutputAdapter.output(LITERAL_NEW_LINE)
    }

    private companion object {
        private const val LITERAL_NEW_LINE = "\n"
    }
}
