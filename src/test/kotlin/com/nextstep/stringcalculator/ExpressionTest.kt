package com.nextstep.stringcalculator

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ExpressionTest : AnnotationSpec() {

    @DisplayName("Expression should take a string expression and split it by ' ' and convert into a list of Element instance")
    @Test
    fun constructor() {
        val expression = Expression("1 + 2")
        expression.elements shouldContainExactly listOf(Number("1"), Operator.PLUS, Number("2"))
    }

    @DisplayName("Expression can calculate")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 - 2, -1", "1 * 2, 2", "1 / 2, 0"])
    fun calculate(stringExpression: String, result: Long) {
        val expression = Expression(stringExpression)
        expression.calculate() shouldBe result
    }
}
