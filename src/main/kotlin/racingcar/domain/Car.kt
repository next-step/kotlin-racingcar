package racingcar.domain

import racingcar.view.OutputView

const val MOVE_MARKER = "- "

class Car(private val movingConditionStrategy: MovingConditionStrategy, var name: String = "") {
    var position = ""

    fun move() {
        if (movingConditionStrategy.move() >= MOVE_FORWARD) {
            markCarPosition(MOVE_MARKER)
        }
    }

    private fun markCarPosition(value: String) {
        position += value
    }

    fun showPosition(isLastCarCycle: Boolean, outputView: OutputView) {
        outputView.showRaceState(name, position, isLastCarCycle)
    }

    companion object {
        const val MOVE_FORWARD = 4
    }
}
