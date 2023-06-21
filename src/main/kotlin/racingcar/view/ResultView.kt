package racingcar.view

import racingcar.domain.RoundHistory

class ResultView {
    companion object {
        fun printHistory(histories: List<RoundHistory>) {
            println("실행 결과")
            histories.forEach {
                printPositions(it.positions)
                println()
            }
        }

        private fun printPositions(positions: List<Int>) {
            val positionInfo = StringBuilder()
            for (it in positions) {
                positionInfo.append("${"-".repeat(it)}\n")
            }

            print(positionInfo.toString())
        }
    }
}
