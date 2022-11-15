package com.nextstep.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ExpressionTest : AnnotationSpec() {

    @DisplayName("Expression should take a string expression and split it by ' ' and convert into a list of Element instance")
    @Test
    fun constructor() {
        val expression = Expression("1 + 2")
        expression.elements shouldContainExactly listOf(Operand("1"), Operator.PLUS, Operand("2"))
    }

    @DisplayName("If the expression is invalid, then throw exception")
    @Test
    fun constructor_exception() {
        shouldThrow<IllegalArgumentException> { Expression("1 + 3 +") } shouldHaveMessage "Input expression is invalid, 1 + 3 +"
        shouldThrow<IllegalArgumentException> { Expression("1 + 3 3") } shouldHaveMessage "String operator should be one of (+, -, *, /), it was: 3"
        shouldThrow<IllegalArgumentException> { Expression("1 + +") } shouldHaveMessage "Input expression is invalid, 1 + +"
        shouldThrow<IllegalArgumentException> { Expression("1 + a") } shouldHaveMessage "Input expression is invalid, 1 + a"
    }

    @DisplayName("Expression can calculate")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 - 2, -1", "1 * 2, 2", "1 / 2, 0", "1 + 2 + 3, 6", "2 / 2 + 3 - 1, 3"])
    fun calculate(stringExpression: String, result: Long) {
        val expression = Expression(stringExpression)
        expression.calculate() shouldBe result
    }

    @DisplayName("If a number is divided by 0, throw exception")
    @Test
    fun calculate_exception() {
        val expression = Expression("1 / 0")
        shouldThrow<ArithmeticException> { expression.calculate() }
    }
}
