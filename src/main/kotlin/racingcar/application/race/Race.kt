package racingcar.application.race

import racingcar.application.model.RaceInputCommand
import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.ParticipatingCars

class Race(
    private val carFactory: CarFactory,
    private val scoreBoard: ScoreBoard
) {

    fun proceed(raceInputCommand: RaceInputCommand) {
        val attemptCount = raceInputCommand.attemptCount
        val participatingCars = carFactory.createByCarNames(carNames = raceInputCommand.carNames)

        race(participatingCars, attemptCount)
    }

    private fun race(participatingCars: ParticipatingCars, attemptCount: Int) {
        scoreBoard.initRace(participatingCars.initNameList())
        repeat(attemptCount) {
            participatingCars.move { position: Int, carName: String ->
                scoreBoard.nextRound(position, carName)
                scoreBoard.term()
            }
        }
        scoreBoard.winnersAnnounce(participatingCars.winnersNameList())
    }
}
