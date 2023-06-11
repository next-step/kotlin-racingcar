package com.racing.step4.view

object OutputView {
    fun showStartMessage() {
        println("실행 결과")
    }

    fun showRacingResultDashboard(carPosition: Map<String, Int>) {
        carPosition.forEach {
            print(it.key + " : ")
            repeat(it.value) {
                print("-")
            }
            println()
        }
        println()
    }

    fun showWinner(winners: String) {
        print(winners + "가 최종 우승했습니다.")
    }
}
