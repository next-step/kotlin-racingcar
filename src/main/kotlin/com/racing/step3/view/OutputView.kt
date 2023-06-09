package com.racing.step3.view

object OutputView : View<String>() {
    fun show(showCarPosition: () -> Unit) {
        exec("실행 결과", showCarPosition)
    }
}
