package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OperationTest {

    @Test
    fun `0으로 나누면 IllegalArgumentException 발생`() {
        Assertions.assertThatThrownBy {
            Operation.DIVIDE.execute(2, 0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
