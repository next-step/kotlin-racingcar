package racingcar.application.race.event.publisher

import racingcar.application.port.output.OutputPort
import racingcar.application.race.event.listener.RoundOutputListener
import racingcar.application.race.event.listener.WinOutputListener
import racingcar.application.race.event.model.RoundEvent
import racingcar.application.race.event.model.WinEvent

class EventPublisher(
    private val outputPort: OutputPort
) {
    fun roundEvent(): RoundEvent {
        return RoundEvent(listeners = listOf(RoundOutputListener(outputPort = outputPort)))
    }

    fun winEvent(): WinEvent {
        return WinEvent(listeners = listOf(WinOutputListener(outputPort = outputPort)))
    }
}
