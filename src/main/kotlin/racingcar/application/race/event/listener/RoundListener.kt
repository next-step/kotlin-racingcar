package racingcar.application.race.event.listener

import racingcar.application.port.output.OutputPort
import racingcar.application.race.event.model.EventState
import racingcar.application.race.event.model.RoundEventCarData

sealed interface RoundListener : RaceListener<RoundEventCarData>

class RoundOutputListener(
    private val outputPort: OutputPort
) : RoundListener {

    override fun publish(roundEventCarData: RoundEventCarData) {
        if (EventState.INIT == roundEventCarData.eventState) {
            outputPort.output(RESULT_COMMENT)
            outputPort.outputNewLine()
        }

        roundEventCarData.carData.forEach {
            outputPort.output("${it.name}: ")
            outputLiteralCurrentPosition(it.position)
            outputPort.outputNewLine()
        }
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_ROUND_SECONDS)
    }

    private fun outputLiteralCurrentPosition(position: Int) {
        repeat(position) {
            outputPort.output(LITERAL_POSITION)
        }
    }

    private companion object {
        private const val RESULT_COMMENT = "처리 결과"
        private const val LITERAL_POSITION = "-"
        private const val PER_RACE_ROUND_SECONDS = 2000L
    }
}
