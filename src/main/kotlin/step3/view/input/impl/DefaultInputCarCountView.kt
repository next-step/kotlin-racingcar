package step3.view.input.impl

import step3.view.input.InputView

class DefaultInputCarCountView : InputView {

    override fun printInputViewForTotalCarCount() {
        println("자동차 대수는 몇 대인가요?")
    }

    override fun printInputViewForTotalTryCount() {
        println("시도할 횟수는 몇 회인가요?")
    }
}
