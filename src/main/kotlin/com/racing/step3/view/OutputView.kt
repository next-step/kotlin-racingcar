package com.racing.step3.view

class OutputView : View<String>() {
    fun show(showCarPosition: () -> Unit) {
        exec("실행 결과", showCarPosition)
    }
}
