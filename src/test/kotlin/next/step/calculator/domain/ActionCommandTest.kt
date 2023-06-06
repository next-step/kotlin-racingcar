package next.step.calculator.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ActionCommandTest {
    @Test
    fun `커맨드가 Q이면 종료`() {
        ActionCommand.Q.isQuit() shouldBe true
    }

    @Test
    fun `전체 액션 커맨드 출력`() {
        ActionCommand.descAll() shouldBe "C: 계산, Q: 종료"
    }
}
