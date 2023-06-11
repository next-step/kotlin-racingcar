package study.step3

import io.kotest.core.spec.style.StringSpec
import study.step3.inputview.InputView
import study.step3.resultview.StdoutResultView

class RacingTests : StringSpec({

    "레이싱을 진행한다" {
        val fakeInputView = object : InputView {
            override fun receive(): InputView.RacingInputResult {
                return InputView.RacingInputResult(numOfCar = 3, numOfAttempt = 5)
            }
        }

        val racing = Racing(fakeInputView, StdoutResultView())

        racing.start()
    }
})
