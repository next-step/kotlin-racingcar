package racingcar.io

object OutputView {
    fun showCarMoveResult(currentPosition: Int) {
        repeat(currentPosition) { print("-") }
        println()
    }

    fun nextTurn() {
        println()
    }
}
