package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculationTest : AnnotationSpec() {

    @ParameterizedTest
    @CsvSource("1 + 10 + 20,31", "2 + 30,32", delimiter = ',')
    fun `단순 더하기 테스트`(input: String, expected: Int) {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate(input)
        // Then
        actual.value shouldBe expected
    }

    @ParameterizedTest
    @CsvSource("30 - 10 - 20,0", "9 - 18,-9", delimiter = ',')
    fun `단순 빼기 테스트`(input: String, expected: Int) {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate(input)
        // Then
        actual.value shouldBe expected
    }

    @ParameterizedTest
    @CsvSource("7 * 10 * 1,70", "1 * 1,1", "9999 * 0,0", delimiter = ',')
    fun `단순 곱하기 테스트`(input: String, expected: Int) {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate(input)
        // Then
        actual.value shouldBe expected
    }

    @ParameterizedTest
    @CsvSource("30 / 5 / 2,3", "1 / 1,1", delimiter = ',')
    fun `단순 나누기 테스트`(input: String, expected: Int) {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate(input)
        // Then
        actual.value shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(
        "10 + 2 / 6 * 3 - 90 * -20,1680",
        "-1 * 1 + 2 / 1,1",
        "2 + 3 * 4 / 2,10",
        "3.9 / 3 + 5,6.3",
        delimiter = ','
    )
    fun `복잡한 사직연산 테스트`(input: String, expected: Double) {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate(input)
        // Then
        actual.value shouldBe expected
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

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "     "])
    fun `입력 값이 공백인 경우 예외 발생`(input: String) {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 / 2 $ 3", "1 gsad adsf", "a + b - c"])
    fun `사직연산이 아닌 기호가 포함되어 있는 경우 예외 발생`(input: String) {
        // Given
        val calculator = StringCalculator()
        // Then
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(input)
        }
    }
}
