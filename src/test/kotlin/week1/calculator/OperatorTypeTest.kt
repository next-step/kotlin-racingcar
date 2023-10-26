package week1.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OperatorTypeTest {
    @Test
    fun `연산자 검증`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            OperatorType.from("_")
            OperatorType.from("@")
            OperatorType.from("#")
        }
        Assertions.assertThatCode {
            OperatorType.values().forEach {
                OperatorType.from(it.value)
            }
        }
    }
}