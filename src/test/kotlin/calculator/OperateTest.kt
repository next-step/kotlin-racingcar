package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperateTest {
    @ParameterizedTest
    @ValueSource(strings = ["*", "/", "+", "-"])
    @DisplayName("연산자 찾기")
    fun findOperate(findOperate: String) {
        assertThat(Operate.generate(findOperate)).isNotNull()
    }

    @Test
    @DisplayName("존재하지 않는 연산자 찾기")
    fun notFoundOperate() {
        assertThrows<NoSuchElementException> {
            Operate.generate("none")
        }
    }

    @Test
    @DisplayName("계산 함수 테스트")
    fun calcMethodSuccess() {
        val sum = Operate.PLUS.calc(10.0, 5.0)
        assert(sum == 15.0)

        val multi = Operate.MULTI.calc(0.0, 20.0)
        assert(multi == 0.0)

        val div = Operate.DIVISION.calc(10.0, 5.0)
        assert(div == 2.0)
    }

    @Test
    @DisplayName("계산 함수 테스트(예외)")
    fun calcMethodFail() {
        assertThrows<IllegalArgumentException> {
            Operate.DIVISION.calc(10.0, 0.0)
        }
    }
}
