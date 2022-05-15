package calculator.study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculateMachineTest : AnnotationSpec() {

    fun `사칙연산 연산자가 포함된 식을 계산한 결괏값 검증`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2"
        val expressionParser = ExpressionParser(ExpressionSyntaxChecker)
        val ast = expressionParser.compile(expr)
        val calculateMachine = CalculateMachine.compile(ast)

        // when
        val result = calculateMachine.calculate()

        // then
        result shouldBe Operand(1)
    }
}
