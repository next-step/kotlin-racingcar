package next.step.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import next.step.calculator.service.Expressions

class ExpressionsTest : FunSpec({
    data class EvaluationExpectation(val expressions: List<String>, val expected: Int)
    context("evaluate") {
        withData(
            nameFn = { "${it.expressions} = ${it.expected}" },
            EvaluationExpectation(listOf("2", "+", "3"), 5),
            EvaluationExpectation(listOf("2", "+", "3", "*", "4"), 20),
            EvaluationExpectation(listOf("2", "/", "1", "*", "4", "+", "2"), 10),
            EvaluationExpectation(listOf("2", "+", "3", "*", "4", "/", "2", "-", "10"), 0),
        ) { (expressionList, expected) ->
            Expressions.evaluate(expressionList) shouldBe expected
        }

        test("expression 개수가 모자라면 예외 발생") {
            shouldThrow<IllegalArgumentException> {
                Expressions.evaluate(listOf("2", "+", "3", "*", "4", "/"))
            }
        }
    }
})
