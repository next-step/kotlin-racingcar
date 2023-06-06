package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class CalculatorKtTest {

    @ParameterizedTest
    @EmptySource
    fun `공백이 입력되는 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { calculate(input) }
        exception.message shouldBe "공백은 계산할 수 없다."
    }
}
