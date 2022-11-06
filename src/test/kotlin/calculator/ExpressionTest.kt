package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class ExpressionTest : StringSpec({
    "문자열 계산기의 입력(수식)은 null일 수 없어요." {
        shouldThrow<IllegalArgumentException> {
            Expression(null)
        }
    }
})
