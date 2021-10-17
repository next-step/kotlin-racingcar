package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["0.0,1.5,1.5", "1.5,1.5,3.0", "111.0,111.0,222.0"])
    fun `더하기 테스트`(input: String) {
        val map: List<Double> = input.split(",").map { i -> i.toDouble() }
        assertThat(Operator.PLUS.function.apply(map[0], map[1])).isEqualTo(map[2])
    }

    @ParameterizedTest
    @ValueSource(strings = ["0.0,1.5,-1.5", "1.5,1.5,0.0", "999.0,111.0,888.0"])
    fun `빼기 테스트`(input: String) {
        val map: List<Double> = input.split(",").map { i -> i.toDouble() }
        assertThat(Operator.MINUS.function.apply(map[0], map[1])).isEqualTo(map[2])
    }

    @ParameterizedTest
    @ValueSource(strings = ["0.0,1.5,0.0", "10.0,1.5,15.0", "9.0,-9.0,-81.0"])
    fun `곱하기 테스트`(input: String) {
        val map: List<Double> = input.split(",").map { i -> i.toDouble() }
        assertThat(Operator.MULTIPLY.function.apply(map[0], map[1])).isEqualTo(map[2])
    }

    @ParameterizedTest
    @ValueSource(strings = ["0.0,1.5,0.0", "1.5,1.5,1.0", "111.0,222.0,0.5"])
    fun `나누기 테스트`(input: String) {
        val map: List<Double> = input.split(",").map { i -> i.toDouble() }
        assertThat(Operator.DIVIDE.function.apply(map[0], map[1])).isEqualTo(map[2])
    }

    @ParameterizedTest
    @ValueSource(strings = ["+ 0.0 1.0 1.0", "- 1.0 1.0 0.0", "* 5.0 5.0 25.0", "/ 6.0 3.0 2.0"])
    fun `함수 적용하기`(input: String) {
        val split = input.split(" ")
        assertThat(Operator.apply(split[0], split[1].toDouble(), split[2].toDouble())).isEqualTo(split[3].toDouble())
    }
}
