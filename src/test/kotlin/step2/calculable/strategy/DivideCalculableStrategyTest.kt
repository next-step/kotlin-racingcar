package step2.calculable.strategy

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DivideCalculableStrategyTest {

    @DisplayName("DivideCalculableStrategy 인스턴스 생성 여부 테스트")
    @Test
    fun constructor_test() {
        // given and when
        val calculable = DivideCalculableStrategy()

        // then
        assertAll(
            { assertThat(calculable).isNotNull },
            { assertThat(calculable).isExactlyInstanceOf(DivideCalculableStrategy::class.java) },
        )
    }

    @DisplayName("DivideCalculableStrategy 인스턴스 calculate() 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:1:1", "-2:2:-1", "-1:-1:1"], delimiter = ':')
    fun calculate_test(x: Int, y: Int, expected: Int) {
        // given
        val calculable = DivideCalculableStrategy()

        // when
        val actual = calculable.calculate(x, y)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("DivideCalculableStrategy 인스턴스 calculate() 기능 실패 테스트")
    @Test
    fun calculate_fail_test() {
        // given
        val calculable = DivideCalculableStrategy()
        val x = 1
        val y = 0

        // when
        assertThatThrownBy { calculable.calculate(x, y) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(DivideCalculableStrategy.DIVIDE_ZERO_MESSAGE)
    }
}
