package study.step4.view

import study.step4.util.CAR_NAME_DELIMITERS

object InputGenerator {
    fun convertRacingCarNamesList(racingCarNames: String): List<String> =
        racingCarNames.split(CAR_NAME_DELIMITERS).map { it.trim() }.toList()
}
