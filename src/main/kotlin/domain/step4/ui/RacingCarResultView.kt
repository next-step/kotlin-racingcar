package domain.step4.ui

import domain.step4.domain.game.RacingCarGameRecord
import domain.step4.domain.racingcar.RacingCar
import domain.step4.domain.racingcar.RacingCars
import global.strategy.output.OutputStrategy
import java.lang.System.lineSeparator
import kotlin.streams.asSequence

class RacingCarResultView(private val outputStrategy: OutputStrategy) {

    fun print(racingCarGameRecord: RacingCarGameRecord) {
        outputStrategy.execute(
            StringBuilder()
                .append(lineSeparator())
                .append("실행 결과")
                .append(lineSeparator())
                .append(resultAllRound(racingCarGameRecord))
                .append(lineSeparator() + lineSeparator())
                .append(showWinners(racingCarGameRecord))
                .append("가 최종 우승했습니다.")
                .toString()
        )
    }

    private fun showWinners(racingCarGameRecord: RacingCarGameRecord): String {
        val last = racingCarGameRecord.racingCarGameRecord.last()
        val winningRacingCars = last.winningRacingCars()
        return winningRacingCars.stream().asSequence()
            .map { racingCar -> racingCar.name }
            .joinToString(", ")
    }

    private fun resultAllRound(racingCarGameRecord: RacingCarGameRecord) =
        racingCarGameRecord.racingCarGameRecord.asSequence()
            .map(this::resultPerRound)
            .joinToString(lineSeparator() + lineSeparator())

    private fun resultPerRound(racingCars: RacingCars): String {
        return racingCars.racingCars.asSequence()
            .map(this::resultPerPerson)
            .joinToString(lineSeparator())
    }

    private fun resultPerPerson(racingCar: RacingCar): String {
        val name = racingCar.name
        return name + CONTOUR + mapToOutputModel(racingCar.distance)
    }

    private fun mapToOutputModel(count: Int) = (START..count).joinToString(BLANK) { OUTPUT_MODEL }

    companion object {
        private const val START = 1
        private const val BLANK = ""
        private const val OUTPUT_MODEL = "-"
        private const val CONTOUR = " : "
    }
}
