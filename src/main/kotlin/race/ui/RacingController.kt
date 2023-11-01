package race.ui

import race.domain.Racing
import race.domain.RacingCar

class RacingController(private val resultView: ResultView) {
    fun sendEvent(eventType: RacingEvent, eventData: Any?) {
        require(eventType.requireData && eventData != null) {
            "Event need data!"
        }

        when (eventType) {
            RacingEvent.START -> {
                require(eventData is InputState)
                val racingResult = Racing(
                    racingCarList = eventData.carNames.map { RacingCar(name = it) },
                    round = eventData.round,
                ).startRace()

                resultView.showResult(racingResult)
            }
        }
    }
}
