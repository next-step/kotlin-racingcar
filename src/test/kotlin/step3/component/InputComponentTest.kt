package step3.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InputComponentTest : FunSpec({
    context("Input 컴포넌트") {
        test("생성 테스트") {
            // given
            val label = "자동차 대수는 몇 대인가요?"
            val onCommand: (String) -> Unit = { }
            // when
            val actual = InputComponent(
                label = label,
                onCommand = onCommand,
            )
            // then
            actual.label shouldBe label
            actual.onCommand shouldBe onCommand
        }

        test("이벤트 리스너 등록 테스트") {
            // given
            val onCommand: (String) -> Unit = {}
            // when
            val actual = InputComponent(label = "자동차 대수는 몇 대인가요?")
            actual.addCommandListener(onCommand)
            // then
            actual.onCommand shouldBe onCommand
        }
    }
})
