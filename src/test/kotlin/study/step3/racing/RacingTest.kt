package study.step3.racing

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.step3.car.CarFactory
import study.step3.generator.RandomNumberGenerator

internal class RacingTest {
    @Test
    fun `자동차가 전진을 한다면 전진한 값을 반환한다`() {
        val randomNumberGenerator = mockk<RandomNumberGenerator>()
        every { randomNumberGenerator.generate() } returns 4

        val racing = Racing(CarFactory.createCars(2), randomNumberGenerator)
        assertThat(racing.attempt()).isEqualTo(listOf(2, 2))
    }
}
