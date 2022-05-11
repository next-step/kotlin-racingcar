package racingcar.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarCountTest {

    @ValueSource(strings = ["0", "-1"])
    @ParameterizedTest(name = "자동차의 대수가 {0} 대 일 때는 오류가 발생한다.")
    fun `게임을 실행 할 자동차의 대수가 0대거나 음수이면 오류가 발생한다`(count: Int) {
        assertThrows<IllegalArgumentException> { CarCount(count) }
    }
}
