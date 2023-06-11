package step3.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class RacingRequestTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2])
    internal fun `0 이하의 값은 허용되지 않는다`(value: Int) {
        assertThatThrownBy { RacingRequest(carCount = value, attemptCount = value) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
