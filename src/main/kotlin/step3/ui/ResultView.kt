package step3.ui

import step3.domain.MovingHistory

/**
 *
 * @author Leo
 */
class ResultView {

    fun showRaceResult(totalCount: Int, movingHistories: List<MovingHistory>) {
        println("실행결과")
        for (index in 0 until totalCount) {
            showRaceResultByCount(index, movingHistories)
            println("")
        }
    }

    private fun showRaceResultByCount(index: Int, movingHistories: List<MovingHistory>) {
        movingHistories.forEach {
            println(it.getProgressBars()[index])
        }
    }
}
