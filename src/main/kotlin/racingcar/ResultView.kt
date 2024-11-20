package racingcar

object ResultView {
    private const val RESULT_TITLE_MESSAGE = "실행 결과"
    private const val MOVE_SYMBOL = "-"
    private const val SEPARATOR = ","

    fun printResultTitle() {
        println(RESULT_TITLE_MESSAGE)
    }

    fun printRaceResult(
        totalPhase: Int,
        raceAggregateSystem: RaceAggregateSystem,
    ) {
        val sb = StringBuilder()
        for (phase in 0 until totalPhase) {
            convertPhaseResultToSymbol(raceAggregateSystem.scoreBoard, sb, phase)
            sb.appendLine()
        }
        println(sb)
        println("${raceAggregateSystem.winners.joinToString(SEPARATOR)}가 최종 우승했습니다.")
    }

    private fun convertPhaseResultToSymbol(
        scoreBoard: ScoreBoard,
        sb: StringBuilder,
        phase: Int,
    ) {
        scoreBoard.board.forEach { (name, record) ->
            sb.appendLine("$name : ${MOVE_SYMBOL.repeat(record.getPhaseRecord(phase))}")
        }
    }
}
