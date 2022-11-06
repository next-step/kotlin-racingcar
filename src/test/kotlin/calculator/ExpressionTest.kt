package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import java.lang.IllegalStateException

class ExpressionTest : StringSpec({
    "문자열 계산기의 입력(수식)은 null일 수 없어요." {
        shouldThrow<IllegalArgumentException> {
            Input(null)
        }
    }

    "문자열 계산기의 입력(수식)은 빈 공백 문열일 수 없어요." {
        listOf("", " ").forAll { expression ->
            shouldThrow<IllegalArgumentException> {
                Input(expression)
            }
        }
    }

    "문자열 계산기의 입력(수식)은 사칙 연산을 제외한 연산자는 들어올 수 없어요." {
        listOf(
            "1 ^ 1",
            "1 % 1",
            "1 x 1",
            "1 X 1",
            "(1 + 1)",
        ).forAll { expression ->
            shouldThrow<IllegalArgumentException> {
                Input(expression)
            }
        }
    }

    "문자열 계산기의 입력(수식)은 사칙 연산과 숫자만 들어올 수 있어요." {
        listOf(
            "1 + 1",
            "1 - 1",
            "1 * 1",
            "1 / 1",
        ).forAll { expression ->
            shouldNotThrow<IllegalStateException> {
                Input(expression)
            }
        }
    }
})
