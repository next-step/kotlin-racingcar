package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarCountTest {

    @Test
    fun `게임을 실행 할 자동차의 대수는 한 대 이상이여야 한다`() {
        val carCount = CarCount(2)
        assertThat(carCount).isEqualTo(CarCount(2))
    }

    @ValueSource(strings = ["0", "-1"])
    @ParameterizedTest(name = "자동차의 대수가 {0} 대 일 때는 진행할 수 없다.")
    fun `게임을 실행 할 자동차의 대수가 0대거나 음수이면 게임을 진행할 수 없다`(count: Int) {
        assertThrows<IllegalArgumentException> { CarCount(count) }
    }
}
