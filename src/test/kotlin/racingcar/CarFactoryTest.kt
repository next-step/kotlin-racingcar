package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarFactoryTest {
    @Test
    internal fun `이름개수와 동일한 개수의 자동차가 생성된다`() {
        assertThat(CarFactory.manufacture(listOf("aaa", "bbb", "abc")).size).isEqualTo(3)
    }
}
