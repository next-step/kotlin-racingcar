package racingcar.domain.vo

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("레이스(Lap)")
class LapTest {
    @Test
    fun `레이스 라운드가 1보다 작은 경우 예외 발생`() {
        assertThatThrownBy { Lap.of(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("레이스 라운드는 1보다 작을 수 없습니다.")
    }
}
