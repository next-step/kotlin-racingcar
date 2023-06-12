package com.racing.step4.view

object OutputView {
    fun showStartMessage() {
        println("실행 결과")
    }

    fun showRacingResultDashboard(carPositionByCarName: Map<String, Int>) {
        carPositionByCarName.forEach {
            showCarNameWithPosition(it.key, it.value)
        }
        println()
    }

    private fun showCarNameWithPosition(name: String, position: Int) {
        print("$name : ")
        repeat(position) {
            print("-")
        }
        println()
    }

    fun showWinner(winners: String) {
        print(winners + "가 최종 우승했습니다.")
    }
}
