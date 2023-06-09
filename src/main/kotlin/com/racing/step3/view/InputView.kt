package com.racing.step3.view

object InputView : View<String>() {
    fun show(getCar: () -> Unit, getTryTime: () -> Unit) {
        exec("자동차 대수는 몇 대인가요?", getCar)
        exec("시도할 횟수는 몇 회인가요?", getTryTime)
    }
}
