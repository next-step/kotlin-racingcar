package racing.model

import racing.port.OutputPainter

class ScoreBoard(private val histories: List<Cars>, private val painter: OutputPainter) {

    fun draw() {
        prologue()
        drawHistories()
        epilogue()
    }

    private fun drawHistories() {
        histories.map { it.toPrintableCars("\n") }.map(painter::draw)
    }

    private fun prologue() {
        painter.draw("\n실행 결과\n")
    }

    private fun epilogue() {
        val winner = Winner(histories.last())
        painter.draw("\n${winner.names()}가 최종 우승하였습니다.\n")
    }
}
