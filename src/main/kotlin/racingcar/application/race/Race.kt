package racingcar.application.race

import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.ParticipatingCars

class Race(
    private val carFactory: CarFactory
) {

    fun getParticipatingCars(carNames: List<String>): ParticipatingCars {
        return carFactory.createByCarNames(carNames = carNames)
    }

    fun currentRace(participatingCars: ParticipatingCars): RoundCarData {
        return participatingCars.currentData()
    }

    fun win(participatingCars: ParticipatingCars): WinCarData {
        return participatingCars.announceWinners()
    }

    private fun ParticipatingCars.currentData(): RoundCarData {
        return RoundCarData(
            this.currentPosition().map {
                CarData(name = it.first, position = it.second)
            }
        )
    }

    private fun ParticipatingCars.announceWinners(): WinCarData {
        return WinCarData(
            this.winners().map {
                CarData(name = it.first, position = it.second)
            }
        )
    }
}
