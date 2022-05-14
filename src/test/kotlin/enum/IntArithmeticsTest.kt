package enum

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class IntArithmeticsTest {
    @Test
    fun `IntArithmetics enum class 의 PLUS 인자로 3과 4를 전달할 경우 결과 값은 7이다`() {
        Assertions.assertThat(IntArithmetics.PLUS.apply(3, 4)).isEqualTo(7)
    }

    @Test
    fun `IntArithmetics enum class 의 MINUS 인자로 4와 3 전달할 경우 결과 값은 1이다`() {
        Assertions.assertThat(IntArithmetics.MINUS.apply(4, 3)).isEqualTo(1)
    }

    @Test
    fun `IntArithmetics enum class 의 MULTIPLE 인자로 3과 4를 전달할 경우 결과 값은 12이다`() {
        Assertions.assertThat(IntArithmetics.MULTIPLE.apply(3, 4)).isEqualTo(12)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-", "+", "*", "/"])
    fun `containOperator에 유효한 연산자가 들어올 경우 리턴값은 true`(input: String) {
        Assertions.assertThat(IntArithmetics.containOperator(input)).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(strings = ["??", "//", "$", "%", "#", "@", "!"])
    fun `containOperator에 유효하지 않은 연산자가 들어올 경우 리턴값은 false`(input: String) {
        Assertions.assertThat(IntArithmetics.containOperator(input)).isEqualTo(false)
    }
}
