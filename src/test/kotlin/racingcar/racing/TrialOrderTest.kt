package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TrialOrderTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 48, 203802, Int.MAX_VALUE])
    fun `인스턴스가 달라도 value가 같으면 동일하다`(value: Int) {
        assertThat(TrialOrder(value)).isEqualTo(TrialOrder(value))
    }
    @ParameterizedTest
    @ValueSource(ints = [0, -1, -278, -2042, Int.MIN_VALUE])
    fun `양수가 아니면 IllegalArgumentException throw`(value: Int) {

        assertThatIllegalArgumentException()
            .isThrownBy { TrialOrder(value) }
            .withMessage("The number must be positive.")
    }
}
