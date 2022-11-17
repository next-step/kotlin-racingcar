package racingcar.domain

import racingcar.view.OutputView

class Car(private val movingConditionStrategy: MovingConditionStrategy, var name: String = "") {
    var position = 0

    fun move() {
        if (movingConditionStrategy.move() >= MOVE_FORWARD) {
            markCarPosition(MOVE_VALUE)
        }
    }

    private fun markCarPosition(value: Int) {
        position += value
    }

    fun showPosition(isLastCarCycle: Boolean, outputView: OutputView) {
        outputView.showRaceState(name, position, isLastCarCycle)
    }

    companion object {
        const val MOVE_FORWARD = 4
        //const val MOVE_MARKER = "- "
        const val MOVE_VALUE = 1
    }
}
