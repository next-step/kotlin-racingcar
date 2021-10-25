package racingcar.random

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.random.Random.randomForward

class RandomTest {
    @Test
    fun `랜덤 발생 정상 작동 확인`() {
        assertThat(randomForward()).isGreaterThanOrEqualTo(0)
    }
}
