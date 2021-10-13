package step2.calculable.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ModCalculableStrategyTest {

    @DisplayName("ModCalculableStrategy 인스턴스 생성 여부 테스트")
    @Test
    fun constructor_test() {
        // given and when
        val calculable = ModCalculableStrategy()

        // then
        assertAll(
            { assertThat(calculable).isNotNull },
            { assertThat(calculable).isExactlyInstanceOf(ModCalculableStrategy::class.java) },
        )
    }

    @DisplayName("ModCalculableStrategy 인스턴스 calculate() 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:1:0", "-2:2:0", "-1:-1:0"], delimiter = ':')
    fun calculate_test(x: Int, y: Int, expected: Int) {
        // given
        val calculable = ModCalculableStrategy()

        // when
        val actual = calculable.calculate(x, y)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
