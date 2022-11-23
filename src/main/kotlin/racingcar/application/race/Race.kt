package racingcar.application.race

import racingcar.application.model.RaceInputCommand
import racingcar.application.race.event.model.CarData
import racingcar.application.race.event.model.EventState
import racingcar.application.race.event.model.RoundEventCarData
import racingcar.application.race.event.model.WinEventCarData
import racingcar.application.race.event.publisher.EventPublisher
import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.ParticipatingCars

class Race(
    private val carFactory: CarFactory,
    private val eventPublisher: EventPublisher
) {

    fun proceed(raceInputCommand: RaceInputCommand) {
        val attemptCount = raceInputCommand.attemptCount
        val participatingCars = carFactory.createByCarNames(carNames = raceInputCommand.carNames)
        race(participatingCars, attemptCount)
    }

    private fun race(participatingCars: ParticipatingCars, attemptCount: Int) {
        eventPublisher.roundEvent().publish(participatingCars.currentEventData(EventState.INIT))
        repeat(attemptCount) {
            participatingCars.move()
            eventPublisher.roundEvent().publish(participatingCars.currentEventData(EventState.PROCESS))
        }
        eventPublisher.winEvent().publish(participatingCars.announceWinners())
    }

    private fun ParticipatingCars.currentEventData(eventState: EventState): RoundEventCarData {
        return RoundEventCarData(
            this.currentPosition().map {
                CarData(name = it.first, position = it.second)
            },
            eventState = eventState
        )
    }

    private fun ParticipatingCars.announceWinners(): WinEventCarData {
        return WinEventCarData(
            this.winners().map {
                CarData(name = it.first, position = it.second)
            }
        )
    }
}
