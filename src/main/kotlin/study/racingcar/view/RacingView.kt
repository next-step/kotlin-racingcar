package study.racingcar.view

import study.racingcar.domain.Racing

data class RacingView(
    val racing: Racing
) {
    fun printRacing() {
        racing.cars.forEach { CarView(it).printPosition() }
        println()
    }

    fun printRaceResult() {
        println(RACE_RESULT_MESSAGE)
    }

    companion object {
        private const val RACE_RESULT_MESSAGE = "실행 결과"
    }
}
