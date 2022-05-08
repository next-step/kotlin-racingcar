package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TryNumberTest {

    @Test
    fun `게임을 실행 할 최소 시도 횟수는 한 번 이상이여야 한다`() {
        val tryNumber = TryNumber(2)
        Assertions.assertThat(tryNumber).isEqualTo(TryNumber(2))
    }

    @ValueSource(strings = ["0", "-1"])
    @ParameterizedTest(name = "게임 실행 횟수가 {0} 번 일 때는 진행할 수 없다.")
    fun `게임을 실행 할 최소 횟수가 0이거나 음수이면 게임을 진행할 수 없다`(count: Int) {
        assertThrows<IllegalArgumentException> { TryNumber(count) }
    }
}