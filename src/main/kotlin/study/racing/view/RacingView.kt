package study.racing.view

import java.lang.StringBuilder

class RacingView {

    companion object {

        private const val PROGRESS_BAR = "-"

        fun inputRacingParameters(message: String): Int {
            try {
                println(message)
                return readln().toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("1이상의 숫자만 입력해 주세요.")
            }
        }

        fun printRacingResult(racingResult: List<Int>) {
            racingResult.forEach { distance ->
                println(drawingRacingProgress(distance))
            }
            roundDivisionBlankLine()
        }

        private fun roundDivisionBlankLine() {
            println()
        }

        private fun drawingRacingProgress(distance: Int): StringBuilder {
            val progress = StringBuilder()
            repeat(distance) {
                progress.append(PROGRESS_BAR)
            }
            return progress
        }
    }
}
