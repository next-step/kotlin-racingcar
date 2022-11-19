package racingcar.view

import racingcar.controller.dto.GameResults

class ConsoleOutput {
    fun printResults() {
        println("실행 결과")
    }

    fun printGameResult(gameResults: GameResults) {
        gameResults.carPositions.forEach(printPositions())
        println()
    }

    private fun printPositions(): (Int) -> Unit = { println(POSITION_MARK.repeat(it)) }

    companion object {
        private const val POSITION_MARK = "_"
    }
}
