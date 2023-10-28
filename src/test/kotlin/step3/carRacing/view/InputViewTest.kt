package step3.carRacing.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe



class InputViewTest : StringSpec({
    "인풋을 통해 자동차의 대수 몇번의 이동시도를 할것인지 입력 받는다" {
        class MockInputReader : InputReader {
            override fun readInput(): Int {
                return 5
            }
        }
        val (carCount, tryCount) = InputView.getInputInfo(MockInputReader())
        carCount shouldBe 5
        tryCount shouldBe 5
    }
})
