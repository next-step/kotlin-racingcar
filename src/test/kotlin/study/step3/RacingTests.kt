package study.step3

import org.junit.jupiter.api.Test
import study.step3.veiw.InputView
import study.step3.veiw.StdoutResultView

class RacingTests {

    @Test
    fun `레이싱을 진행한다`() {
        val fakeInputView = object : InputView {
            override fun receive(): InputView.RacingInputResult {
                return InputView.RacingInputResult(numOfCar = 3, numOfAttempt = 5)
            }
        }

        val racing =
            Racing(fakeInputView, StdoutResultView())

        racing.start()
    }
}
