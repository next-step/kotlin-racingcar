package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

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

    @Test
    fun `홀수번째에 있는 값은 숫자가 입력되지 않는 경우 예외가 발생한다`() {
        val input = "a + 2"

        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "수식에 숫자가 아닌 값이 입력될 수 없다."
    }
}
