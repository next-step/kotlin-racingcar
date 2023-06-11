package study.step3

import study.step3.inputview.StdinInputView
import study.step3.resultview.StdoutResultView

fun main() {
    val racing = Racing(StdinInputView(), StdoutResultView())
    racing.start()
}
