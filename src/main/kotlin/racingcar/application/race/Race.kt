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
        val endNumber = raceInputCommand.attemptCount
        val participatingCars = carFactory.create(raceInputCommand.carCount)

        outputPort.output(RESULT_COMMENT)
        race(participatingCars, endNumber)
    }

    private fun race(participatingCars: ParticipatingCars, endNumber: Int) {
        participatingCars.initRace()
        participatingCars.startRace(endNumber)
    }

    private fun ParticipatingCars.initRace() {
        outputPort.outputNewLine()
        this.initRace {
            outputPort.output(LITERAL_POSITION)
            outputPort.outputNewLine()
        }
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_SECONDS)
    }

    private fun ParticipatingCars.startRace(endNumber: Int) {
        IntRange(start = START_ROUND_NUMBER, endInclusive = endNumber).forEach { _ ->
            this.nextRound()
        }
    }

    private fun ParticipatingCars.nextRound() {
        this.move { position: Int ->
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
        private const val START_ROUND_NUMBER = 0
    }
}
