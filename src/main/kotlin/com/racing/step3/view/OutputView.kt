package com.racing.step3.view

object OutputView : View<String>() {
    fun showResultKeyword() {
        exec("실행 결과") {}
    }

    fun showCarPosition(position: Int) {
        for (i in 1..position) {
            print("-")
        }
        showBlank()
    }

    fun showBlank() {
        println()
    }
}
