package racing

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.model.Times
import racing.model.Times.Companion.INVALID_TIMES

class TimesTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `횟수 입력 개수 에러 테스트`(times: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Times(times)
        }.withMessage(INVALID_TIMES)
    }
}
