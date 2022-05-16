package racing.view

import racing.common.CarRaceProperty

class ResultView(private val carRaceProperty: CarRaceProperty) {

    fun printResultByRound(round: Int) {
        println("-- [$round]회차 결과 ------")
        carRaceProperty.cars.map { printForwardMoveMark(it.moveCount) }
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
