package com.nextstep.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest : AnnotationSpec() {

    @DisplayName("If StringCalculator take empty string, throw IllegalArgumentException")
    @Test
    fun constructor_exception() {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(null)
        } shouldHaveMessage "Input shouldn't be null or blank"

        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(" ")
        } shouldHaveMessage "Input shouldn't be null or blank"
    }

    @DisplayName("String calculator can calculate string expression")
    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 - 2, -1", "1 * 2, 2", "1 / 2, 0"])
    fun calculate(expression: String, result: Long) {
        StringCalculator.calculate(expression) shouldBe result
    }
}
