package study.racing.view

import study.racing.domain.Cars

object RacingView {

    private const val PROGRESS_BAR = "-"

    fun inputRacingCarNamesParameters(message: String): String {
        try {
            println(message)
            return readln()
        } catch (e: Exception) {
            throw IllegalArgumentException("1이상의 숫자만 입력해 주세요.")
        }
    }

    fun inputRacingRoundParameters(message: String): Int {
        try {
            println(message)
            return readln().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("1이상의 숫자만 입력해 주세요.")
        }
    }

    fun printRacingResult(cars: Cars) {
        cars.forEach {
            println("${it.getCarName()} : ${PROGRESS_BAR.repeat(it.getCarDistance())}")
        }
        roundDivisionBlankLine()
    }

    private fun roundDivisionBlankLine() {
        println()
    }

    fun printRacingWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종우승 했습니다.")
    }

    fun printRacingGameTitle() {
        roundDivisionBlankLine()
        println("실행 결과")
    }
}
