package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorKtTest {

    @ParameterizedTest
    @EmptySource
    fun `공백이 입력되는 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "공백은 계산할 수 없다."
    }

    @Test
    fun `숫자와 연산자의 조합으로 된 올바른 수식의 형태로 입력되지 않는 경우 예외가 발생한다`() {
        val input = "1 +"

        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "올바른 형태로 수식을 입력하여야 한다."
    }

    @ParameterizedTest
    @ValueSource(strings = ["a + 2", "2 + a"])
    fun `홀수번째에 있는 값은 숫자가 입력되지 않는 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "올바른 숫자를 입력하여야 한다."
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 & 3", "1 # 4"])
    fun `짝수번째에 있는 값는 연산자가 입력되지 않는 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "올바른 연산자를 입력하여야 한다."
    }

    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "3 + 4, 7", "1 + 2 + 3, 6"])
    fun `덧셈 부호를 연산할 수 있다`(input: String, expected: Int) {
        val actual = calculate(input)

        actual shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(value = ["2 - 1, 1", "10 - 3, 7", "1 - 3, -2", "10 - 3 - 2, 5"])
    fun `뺄셈 부호를 연산할 수 있다`(input: String, expected: Int) {
        val actual = calculate(input)

        actual shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(value = ["2 * 2, 4", "3 * -1, -3", "4 * 8 * 2, 64"])
    fun `곱셈 부호를 연산할 수 있다`(input: String, expected: Int) {
        val actual = calculate(input)

        actual shouldBe expected
    }

    @Test
    fun `나눗셈 부호는 0으로 나눌 경우 예외가 발생한다`() {
        val input = "1 / 0"

        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "숫자는 0으로 나눌 수 없다."
    }

    @ParameterizedTest
    @CsvSource(value = ["4 / 2, 2", "10 / 2, 5", "30 / 3 / 5, 2"])
    fun `나눗셈 부호를 연산할 수 있다`(input: String, expected: Int) {
        val actual = calculate(input)

        actual shouldBe expected
    }

    @Test
    fun `혼합된 연산을 할 수 있다`() {
        val input = "2 + 3 * 4 / 2"

        val actual = calculate(input)

        actual shouldBe 10
    }
}
