package racingcar.application.race

import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.ParticipatingCars

class Race(
    private val carFactory: CarFactory
) {

    fun getParticipatingCars(carNames: List<String>): ParticipatingCars {
        return carFactory.createByCarNames(carNames = carNames)
    }

    fun currentCarPositions(participatingCars: ParticipatingCars): List<Pair<String, Int>> {
        return participatingCars.currentPosition()
    }

    fun win(participatingCars: ParticipatingCars): List<Pair<String, Int>> {
        return participatingCars.winners()
    }
}
