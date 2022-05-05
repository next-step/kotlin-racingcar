package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculationTest : AnnotationSpec() {

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
    fun `입력 값이 null 인 경우 예외 발생`() {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(null)
        }
    }

    @Test
    fun `입력 값이 공백인 경우 예외 발생`() {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("")
        }
    }

    @Test
    fun `사직연산이 아닌 기호가 포함되어 있는 경우 예외 발생`() {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("4 / 2 $ 3")
        }
    }
}
