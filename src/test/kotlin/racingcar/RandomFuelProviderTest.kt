package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.fuelproviders.RandomFuelProvider

class RandomFuelProviderTest {
    @Test
    fun `minFuel 와 maxFuel 사이의 Int 를 리턴 한다`() {
        val fuel = RandomFuelProvider(minFuel = 0, maxFuel = 1).getFuel()
        assertThat(fuel).isBetween(0, 1)
    }
}
