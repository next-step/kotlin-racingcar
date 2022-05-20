package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.exception.TimesException
import racing.domain.vo.Times

class TimesTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `횟수 입력 개수 에러 테스트`(times: Int) {
        assertThrows<TimesException> { Times(times) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 11])
    fun `횟수 입력 통과 테스트`(times: Int) {
        val time = Times(times)
        assertThat(time.value).isEqualTo(times)
    }
}
