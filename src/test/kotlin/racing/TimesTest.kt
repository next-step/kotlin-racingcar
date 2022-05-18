package racing

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.exception.TimesException
import racing.model.Times

class TimesTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `횟수 입력 개수 에러 테스트`(times: Int) {
        assertThrows<TimesException> { Times(times) }
    }
}
