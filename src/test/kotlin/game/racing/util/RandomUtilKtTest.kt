package game.racing.util

import game.racing.domain.Car
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RandomUtilKtTest {
    @Test
    fun `0부터 9사이의 랜덤값을 반환한다`() {
        repeat(10) {
            Assertions.assertThat(getRandomValue()).isBetween(Car.MIN_RANDOM_VALUE, Car.MAX_RANDOM_VALUE)
        }
    }
}
