package calculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class OperatorsTest {

    @Test
    fun `연산자 확인`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Operators.getOperator("a") }
    }
}
