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
}
