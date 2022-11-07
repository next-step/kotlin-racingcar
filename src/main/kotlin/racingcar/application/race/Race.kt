package racingcar.application.race

import racingcar.application.model.RacingCarInputCommand
import racingcar.application.port.output.OutputPort
import racingcar.application.race.factory.CarFactory

class Race(
    private val outputPort: OutputPort,
    private val carFactory: CarFactory
) {

    fun proceed(racingCarInputCommand: RacingCarInputCommand) {
        val endNumber = racingCarInputCommand.attemptCount
        val participatingCars = carFactory.create(racingCarInputCommand.carCount)

        outputPort.output(RESULT_COMMENT)
        race(participatingCars, endNumber)
    }

    private fun race(participatingCars: ParticipatingCars, endNumber: Int) {
        participatingCars.initRace()
        participatingCars.startRace(endNumber)
    }

    private fun ParticipatingCars.initRace() {
        outputPort.outputNewLine()
        this.sizeRange().forEach { _ ->
            outputPort.output(LITERAL_POSITION)
            outputPort.outputNewLine()
        }
        outputPort.outputNewLine()
        Thread.sleep(PER_RACE_SECONDS)
    }

    private fun ParticipatingCars.startRace(endNumber: Int) {
        for (i in 1..endNumber) {
            this.nextRound()
        }
    }

    private fun ParticipatingCars.nextRound() {
        this.move { position: Int ->
            for (i in 0..position) {
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
    }
}
