package step3.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step3.ui.Input

class InputTest : FunSpec({
    context("Input") {
        test("생성 테스트") {
            // given
            val onCommand: (String) -> Unit = { }
            // when
            val actual = Input(onCommand = onCommand)
            // then
            actual.onCommand shouldBe onCommand
        }

        test("이벤트 리스너 등록 테스트") {
            // given
            val onCommand: (String) -> Unit = {}
            // when
            val actual = Input()
            actual.addCommandListener(onCommand)
            // then
            actual.onCommand shouldBe onCommand
        }
    }
})
