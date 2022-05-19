package racing.scene

import racing.model.Cars
import racing.model.ScoreBoard
import racing.port.OutputPainter

class ResultScene(
    private val scoreBoard: ScoreBoard,
    private val painter: OutputPainter,
) {

    fun draw() {
        prologue()
        drawHistory()
        epilogue()
    }

    private fun drawHistory() {
        scoreBoard.map {
            printCars(it)
            painter.draw("\n")
        }
    }

    private fun printCars(cars: Cars) =
        cars.map {
            painter.draw("${it}\n")
        }

    private fun prologue() {
        painter.draw("\n실행결과\n")
    }

    private fun epilogue() {
        val finalRound = scoreBoard.last()
        painter.draw("${finalRound.winnerNames().joinToString(", ")}가 최종 우승했습니다.")
    }
}
