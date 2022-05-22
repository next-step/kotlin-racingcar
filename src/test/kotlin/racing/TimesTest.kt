package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.vo.Times
import racing.exception.TimesException

class TimesTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `횟수는 0이하일 때 실패한다`(times: Int) {
        assertThrows<TimesException> { Times(times) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 11])
    fun `횟수는 0보다 크면 통과한다`(times: Int) {
        val time = Times(times)
        assertThat(time.value).isEqualTo(times)
    }
}
