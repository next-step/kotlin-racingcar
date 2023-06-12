package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarFactoryTest {
    @Test
    internal fun `요청한 값에 맞는 개수의 자동차가 생성된다`() {
        assertThat(CarFactory.manufacture(3).size).isEqualTo(3)
    }
}
