package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @Test
    fun `더하기 테스트`() {
        assertThat(Operator.PLUS.function.apply(0.0, 1.5)).isEqualTo(1.5)
        assertThat(Operator.PLUS.function.apply(1.5, 1.5)).isEqualTo(3.0)
        assertThat(Operator.PLUS.function.apply(111.0, 111.0)).isEqualTo(222.0)
    }

    @Test
    fun `빼기 테스트`() {
        assertThat(Operator.MINUS.function.apply(0.0, 1.5)).isEqualTo(-1.5)
        assertThat(Operator.MINUS.function.apply(1.5, 1.5)).isEqualTo(0.0)
        assertThat(Operator.MINUS.function.apply(999.0, 111.0)).isEqualTo(888.0)
    }

    @Test
    fun `곱하기 테스트`() {
        assertThat(Operator.MULTIPLY.function.apply(0.0, 1.5)).isEqualTo(0.0)
        assertThat(Operator.MULTIPLY.function.apply(10.0, 1.5)).isEqualTo(15.0)
        assertThat(Operator.MULTIPLY.function.apply(9.0, -9.0)).isEqualTo(-81.0)
    }

    @Test
    fun `나누기 테스트`() {
        assertThat(Operator.DIVIDE.function.apply(0.0, 1.5)).isEqualTo(0.0)
        assertThat(Operator.DIVIDE.function.apply(1.5, 1.5)).isEqualTo(1.0)
        assertThat(Operator.DIVIDE.function.apply(111.0, 222.0)).isEqualTo(0.5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+ 0.0 1.0 1.0", "- 1.0 1.0 0.0", "* 5.0 5.0 25.0", "/ 6.0 3.0 2.0"])
    fun `함수 적용하기`(input: String) {
        val split = input.split(" ")
        assertThat(Operator.apply(split[0], split[1].toDouble(), split[2].toDouble())).isEqualTo(split[3].toDouble())
    }
}
