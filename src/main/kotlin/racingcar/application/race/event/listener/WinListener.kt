package racingcar.application.race.event.listener

import racingcar.application.port.output.OutputPort
import racingcar.application.race.event.model.WinEventCarData
import java.util.*

sealed interface WinListener : RaceListener<WinEventCarData>

class WinOutputListener(
    private val outputPort: OutputPort
) : WinListener {

    override fun publish(winEventCarData: WinEventCarData) {
        outputPort.output("우승자 발표")
        outputPort.outputNewLine()
        outputPort.output("두구두구두구----")
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_ROUND_SECONDS)

        val stringJoiner = StringJoiner(",")
        winEventCarData.carData.map { stringJoiner.add(it.name) }
        outputPort.output("${stringJoiner}가 최종 우승했습니다 !!!")
        outputPort.outputNewLine()
    }

    private companion object {
        private const val PER_RACE_ROUND_SECONDS = 2000L
    }
}
