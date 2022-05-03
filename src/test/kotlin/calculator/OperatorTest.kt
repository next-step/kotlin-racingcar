package calculator

import calculator.Operator.ADDITION
import calculator.Operator.DIVISION
import calculator.Operator.MULTIPLICATION
import calculator.Operator.SUBTRACTION
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

internal class OperatorTest : AnnotationSpec() {

    @Test
    fun `문자열로 연산자 찾기`() {
        // given
        listOf(
            "+" to ADDITION,
            "-" to SUBTRACTION,
            "*" to MULTIPLICATION,
            "/" to DIVISION,

            // when
            // then
        ).forAll { (symbol, expected) -> Operator.of(symbol) shouldBe expected }
    }

    @Test
    fun `지원하지 않는 연산자 예외`() {

        val exception = shouldThrow<IllegalArgumentException> {
            Operator.of("^")
        }

        exception.message should startWith("지원하지")
    }

    @Test
    fun `기본 사칙연산`() {
        // given
        listOf(
            ADDITION to 6,
            SUBTRACTION to 2,
            MULTIPLICATION to 8,
            DIVISION to 2,

            // when
            // then
        ).forAll { (operator, expected) -> operator.operate(4, 2) shouldBe expected }
    }
}