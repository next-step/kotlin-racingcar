package domain.step4.ui

import domain.step4.domain.game.RacingCarGameRecord
import domain.step4.domain.racingcar.RacingCar
import domain.step4.domain.racingcar.RacingCars
import global.strategy.output.OutputStrategy
import java.lang.System.lineSeparator

class RacingCarResultView(private val outputStrategy: OutputStrategy) {

    fun print(racingCarGameRecord: RacingCarGameRecord) {
        val result = racingCarGameRecord.racingCarGameRecord.asSequence()
            .map(this::stringPerRound)
            .joinToString(lineSeparator() + lineSeparator())

        outputStrategy.execute(StringBuilder()
            .append("실행 결과")
            .append(lineSeparator())
            .append(result)
            .toString())
    }

    private fun stringPerRound(racingCars: RacingCars) = racingCars.racingCars.asSequence()
        .map(RacingCar::distance)
        .map(this::mapToOutputModel)
        .joinToString(lineSeparator())

    private fun mapToOutputModel(count: Int) = (START..count).joinToString(BLANK) { OUTPUT_MODEL }

    companion object {
        private const val START = 1
        private const val BLANK = ""
        private const val OUTPUT_MODEL = "-"
    }
}
