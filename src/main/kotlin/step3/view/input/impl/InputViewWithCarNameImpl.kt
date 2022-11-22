package step3.view.input.impl

import step3.view.input.InputView

class InputViewWithCarNameImpl : InputView {

    override fun printInputViewForTotalCarCount() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    override fun printInputViewForTotalTryCount() {
        println("시도할 횟수는 몇 회인가요?")
    }
}
