package study.calculator

import calculator.ArithmeticExpression
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import java.lang.IllegalArgumentException

class ExpressionTest : StringSpec({
    "연산식이 올바른 경우 정상적으로 생성된다." {
        expressions.forAll { expression ->
            shouldNotThrow<Throwable> { ArithmeticExpression(expression) }
        }
    }

    "연산식이 공백인 경우 Exception을 반환한다" {
        listOf("", " ").forAll {expression ->
            shouldThrow<IllegalArgumentException> {
                ArithmeticExpression(expression)
            }
        }
    }
}) {
    companion object {
        val expressions = listOf(
            "1 + 3",
            "1 + 2 - 3 * 4 / 5",
            "1"
        )
    }
}
