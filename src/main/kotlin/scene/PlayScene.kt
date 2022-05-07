package scene

import dto.InputResult
import gameobj.ScoreBoard
import port.OutputPainter

class PlayScene(
    private val outputPainter: OutputPainter,
    private val inputResult: InputResult,
) : Iterator<ScoreBoard> {

    var currentRound = 0

    private var cars = inputResult.cars

    override fun hasNext(): Boolean = currentRound < inputResult.round

    override fun next(): ScoreBoard {
        prev()
        update()
        return ScoreBoard(outputPainter, cars)
    }

    private fun update() {
        cars = cars.map {
            it.moveForward(4)
        }
    }

    private fun prev() {
        currentRound++
    }
}
