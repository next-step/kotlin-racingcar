package racingcar.view

import racingcar.`in`.dto.GameResults

class ConsoleOutput {
    fun printGameStartSignal() {
        println("실행 결과")
    }

    fun printGameResult(gameResults: GameResults) {
        for (i in gameResults.names.indices) {
            printResult(gameResults.names[i], gameResults.carPositions[i])
        }

        println()
    }

    fun printWinners(names: List<String>) = println("${names.joinToString { it }}가 최종 우승했습니다.")

    private fun printResult(name: String, position: Int): Unit = println("$name : ${POSITION_MARK.repeat(position)}")

    companion object {
        private const val POSITION_MARK = "_"
    }
}
