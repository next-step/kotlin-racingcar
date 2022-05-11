package step3.view

import step3.CarRaceConst.car

class ResultView {

    fun printResultByRound(round: Int) {
        println("-- [$round]회차 결과 ------")
        car.map { printForwardMoveMark(it.value.moveCount) }
        println("--------------------")
    }

    private fun printForwardMoveMark(move: Int) {
        repeat(move) {
            print(MARK_FORWARD_MOVE)
        }

        println()
    }

    companion object {
        private const val MARK_FORWARD_MOVE = "> "
    }
}
