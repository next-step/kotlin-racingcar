package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomGeneratorTest {
    @Test
    fun `0~9 사이 숫자만 생성되는지 확인`() {
        // 정확한 검증이 어려워 일정 횟수만 확인해본다
        repeat(100) {
            val randomValue = RandomGenerator().value
            Assertions.assertThat(randomValue).isGreaterThan(-1)
            Assertions.assertThat(randomValue).isLessThan(10)
        }
    }
}
