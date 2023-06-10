package com.racing.step3.view

object OutputView : View<String>() {
    fun showResultKeyword() {
        exec("실행 결과") {}
    }

    fun showRaceStage(carPosition: List<Int>) {
        carPosition.forEach {
            showCarPosition(it)
        }
        println()
    }

    private fun showCarPosition(position: Int) {
        repeat(position) {
            print("-")
        }
        println()
    }
}
