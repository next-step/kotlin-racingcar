package study.calculator

import calculator.ArithmeticExpression
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import java.lang.IllegalArgumentException

class ExpressionTest : StringSpec({
    "연산식이 공백인 경우 Exception을 반환한다" {
        listOf("", " ").forAll {expression ->
            shouldThrow<IllegalArgumentException> {
                ArithmeticExpression(expression)
            }
        }
    }
})
