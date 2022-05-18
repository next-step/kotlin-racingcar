package racingcar.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TryNumberTest {

    @ValueSource(strings = ["-1", "-2"])
    @ParameterizedTest(name = "게임 실행 횟수가 {0} 번으로 음수일 경우 오류가 발생한다.")
    fun `게임을 실행 할 최소 횟수가 음수이면 오류가 발생한다`(count: Int) {
        assertThrows<IllegalArgumentException> { TryNumber(count) }
    }
}
