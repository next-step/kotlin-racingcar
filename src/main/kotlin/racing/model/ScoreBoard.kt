package racing.model

import racing.port.OutputPainter

class ScoreBoard(
    private val histories: List<Cars>,
    private val painter: OutputPainter,
) {

    init {
        require(histories.isNotEmpty())
    }

    fun draw() {
        prologue()
        drawHistories()
        epilogue()
    }

    private fun drawHistories() {
        histories.map {
            printCars(it)
            painter.draw("\n")
        }
    }

    private fun printCars(cars: Cars) =
        cars.forEach {
            painter.draw("${it}\n")
        }

    private fun prologue() {
        painter.draw("\n실행결과\n")
    }

    private fun epilogue() {
        val winner = Winner(histories.last())
        painter.draw("${winner.names()}가 최종 우승했습니다.")
    }
}
