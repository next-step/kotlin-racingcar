package calculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @MethodSource("operators")
    fun `연산 기호가 입력됐을 때 연산자를 식별한다`(symbol: String, expect: Operator) {
        val actual = symbol.findOperator()
        actual shouldBe expect
    }

    @ParameterizedTest
    @ValueSource(strings = ["!", "@", "#", "$", "%", "^", "&", "(", ")"])
    fun `연산 기호가 아닌 것이 입력됐을 때 IllegalArgumentException 발생한다`(symbol: String) {
        shouldThrow<IllegalArgumentException> {
            symbol.findOperator()
        }
    }

    @Test
    fun `연산 기호를 통해 두 숫자 간 덧셈, 뺄셈, 곱셈, 나눗셈을 수행할 수 있다`() {
        assertSoftly {
            Operator.PLUS.apply(10, 10) shouldBe 20
            Operator.MINUS.apply(10, 10) shouldBe 0
            Operator.MULTIPLY.apply(10, 10) shouldBe 100
            Operator.DIVIDE.apply(10, 10) shouldBe 1
        }
    }

    companion object {
        @JvmStatic
        fun operators() = listOf(
            Arguments { arrayOf("+", Operator.PLUS) },
            Arguments { arrayOf("-", Operator.MINUS) },
            Arguments { arrayOf("*", Operator.MULTIPLY) },
            Arguments { arrayOf("/", Operator.DIVIDE) }
        )
    }
}
