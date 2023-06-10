package study.racinggame.race

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import study.racinggame.domain.Car
import study.racinggame.race.mock.MockInputReader
import study.racinggame.race.view.InputView
import java.lang.IllegalArgumentException

class InputViewTest : BehaviorSpec({
    given("커맨드 입력 테스트") {

        `when`("park,sejun과 5가 정확하게 입력한 경우") {
            val mockInputReader = MockInputReader(listOf("park,sejun", "5"))
            val inputView = InputView().initInputView(mockInputReader)
            then("정상적으로 값이 입력된다") {
                val names = inputView.carStorage().map(Car::name)
                names shouldBe listOf("park", "sejun")
                inputView.raceTryCnt() shouldBe 5
            }
        }

        `when`("자동차 이름은 5자를 초과할 수 없습니다.") {
            val mockInputReader = MockInputReader(listOf("parkjun5", "2"))

            then("IllegalArgumentException 에러가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    InputView().initInputView(mockInputReader)
                }.message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
            }
        }

        `when`("시도할 값을 숫자가 아닌 문자로 입력된 경우") {
            val mockInputReader = MockInputReader(listOf("park", "@"))

            then("IllegalArgumentException 에러가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    InputView().initInputView(mockInputReader)
                }.message shouldBe "시도할 횟수를 숫자로 입력해주세요."
            }
        }
    }
})
