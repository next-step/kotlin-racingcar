package step4.ui

import step4.domain.MovingHistory

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

    fun showWinners(names: String) {
        println("$names 가 최종 우승했습니다.")
    }

    private fun showRaceResultByCount(index: Int, movingHistories: List<MovingHistory>) {
        movingHistories.forEach {
            println(it.getProgressBars()[index])
        }
    }
}
