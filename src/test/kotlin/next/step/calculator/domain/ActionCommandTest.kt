package next.step.calculator.domain

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ActionCommandTest : ShouldSpec({
    should("커맨드가 Q이면 종료") {
        ActionCommand.Q.isQuit() shouldBe true
    }

    should("전체 액션 커맨드 출력") {
        ActionCommand.descAll() shouldBe "C: 계산, Q: 종료"
    }
})
