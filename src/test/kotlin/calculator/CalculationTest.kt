package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculationTest : AnnotationSpec() {
    // TODO: 사칙연산 기호가 아닌 경우 IllegalArgumentException 이 발생하는지 확인

    @Test
    fun `단순 더하기 테스트`() {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate("1 + 10 + 20")
        // Then
        actual.value shouldBe 31
    }

    @Test
    fun `단순 빼기 테스트`() {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate("30 - 10 - 20")
        // Then
        actual.value shouldBe 0
    }

    @Test
    fun `단순 곱하기 테스트`() {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate("7 * 10 * 1")
        // Then
        actual.value shouldBe 70
    }

    @Test
    fun `단순 나누기 테스트`() {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate("30 / 5 / 2")
        // Then
        actual.value shouldBe 3
    }

    @Test
    fun `입력 값이 null 인 경우`() {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(null)
        }
    }

    @Test
    fun `입력 값이 공백인 경우`() {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("")
        }
    }
}
