package com.racing.step4.view

object OutputView {
    fun showRacingResultDashboard(stageResultList: List<String>) {
        println("실행 결과")
        stageResultList.forEach {
            println(it)
        }
    }

    fun showWinner(winners: String) {
        print(winners + "가 최종 우승했습니다.")
    }
}
