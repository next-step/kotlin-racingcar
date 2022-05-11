package operator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTokenTest {

    @Test
    fun `함수형 인터페이스 테스트`() {
        val token = OperatorToken.getInstance("+")
        val result = token.calculate(Operand(3.0), Operand(2.0))

        assertThat(result).isEqualTo(Operand(5.0))
    }
}
