package racingcar.ui

import racingcar.application.RaceResult
import racingcar.application.RaceResults

object RaceResultGenerator {
    private const val NAME_POSITION_SEPARATOR = " : "
    private const val POSITION_STRING = "-"

    fun generate(raceResults: RaceResults): String {
        val lineSeparator = System.lineSeparator()
        return raceResults.values.joinToString(separator = lineSeparator, postfix = lineSeparator) { raceResult ->
            convertToResultFormat(raceResult)
        }
    }

    private fun convertToResultFormat(raceResult: RaceResult): String {
        return raceResult.carName + NAME_POSITION_SEPARATOR + POSITION_STRING.repeat(raceResult.carPosition)
    }
}
