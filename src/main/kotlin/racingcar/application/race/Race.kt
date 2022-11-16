package racingcar.application.race

import racingcar.application.model.RaceInputCommand
import racingcar.application.port.output.OutputPort
import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.ParticipatingCars

class Race(
    private val outputPort: OutputPort,
    private val carFactory: CarFactory
) {

    fun proceed(raceInputCommand: RaceInputCommand) {
        val attemptCount = raceInputCommand.attemptCount
        val participatingCars = carFactory.createByCarNames(carNames = raceInputCommand.carNames)

        outputPort.output(RESULT_COMMENT)
        race(participatingCars, attemptCount)
    }

    private fun race(participatingCars: ParticipatingCars, attemptCount: Int) {
        participatingCars.initRace()
        participatingCars.startRace(attemptCount)
    }

    private fun ParticipatingCars.initRace() {
        outputPort.outputNewLine()
        this.initRace { carName: String ->
            outputPort.output("$carName: ")
            outputPort.output(LITERAL_POSITION)
            outputPort.outputNewLine()
        }
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_SECONDS)
    }

    private fun ParticipatingCars.startRace(attemptCount: Int) {
        repeat(attemptCount) { this.nextRound() }
    }

    private fun ParticipatingCars.nextRound() {
        this.move { position: Int, carName: String ->
            outputPort.output("$carName: ")
            IntRange(start = START_POSITION_NUMBER, endInclusive = position).forEach { _ ->
                outputPort.output(LITERAL_POSITION)
            }
            outputPort.outputNewLine()
        }
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_SECONDS)
    }

    private companion object {
        private const val RESULT_COMMENT = "처리 결과"
        private const val LITERAL_POSITION = "-"
        private const val PER_RACE_SECONDS = 2000L
        private const val START_POSITION_NUMBER = 0
    }
}
