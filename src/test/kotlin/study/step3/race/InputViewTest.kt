package study.step3.race

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import study.step3.race.mock.MockInputReader
import java.lang.IllegalArgumentException

class InputViewTest : BehaviorSpec({
    given("커맨드 입력 테스트") {

        `when`("3과 5가 정확하게 입력한 경우") {
            val mockInputReader = MockInputReader(listOf("3", "5"))
            val inputView = InputView(mockInputReader)
            inputView.setCommand()
            then("정상적으로 값이 입력된다") {
                inputView.carStorage().size shouldBe 3
                inputView.raceTryCnt() shouldBe 5
            }
        }

        `when`("자동차 대수을 숫자가 아닌 문자로 입력된 경우") {
            val mockInputReader = MockInputReader(listOf("!!!", "@"))
            val inputView = InputView(mockInputReader)

            then("IllegalArgumentException 에러가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    inputView.setCommand()
                }.message shouldBe "자동차 대수를 숫자로 입력해주세요."
            }
        }

        `when`("시도할 값을 숫자가 아닌 문자로 입력된 경우") {
            val mockInputReader = MockInputReader(listOf("3", "@"))
            val inputView = InputView(mockInputReader)

            then("IllegalArgumentException 에러가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    inputView.setCommand()
                }.message shouldBe "시도할 횟수를 숫자로 입력해주세요."
            }
        }
    }
})
