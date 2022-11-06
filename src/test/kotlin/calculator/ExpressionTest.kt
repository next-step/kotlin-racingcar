package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class ExpressionTest : StringSpec({
    "문자열 계산기의 입력(수식)은 null일 수 없어요." {
        shouldThrow<IllegalArgumentException> {
            Expression(null)
        }
    }

    "문자열 계산기의 입력(수식)은 빈 공백 문열일 수 없어요." {
        listOf("", " ").forAll {
            expression ->
            shouldThrow<IllegalArgumentException> {
                Expression(expression)
            }
        }
    }
})
