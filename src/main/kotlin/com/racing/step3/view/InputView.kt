package com.racing.step3.view

object InputView : View<String>() {
    fun readCarNumber(getCar: () -> Unit) {
        exec("자동차 대수는 몇 대인가요?", getCar)
    }

    fun readStageNumber(getStageNum: () -> Unit) {
        exec("시도할 횟수는 몇 회인가요?", getStageNum)
    }
}
