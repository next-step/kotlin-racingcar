package study.step3

import study.step3.veiw.StdinInputView
import study.step3.veiw.StdoutResultView

fun main() {
    val racing = Racing(StdinInputView(), StdoutResultView())
    racing.start()
}
