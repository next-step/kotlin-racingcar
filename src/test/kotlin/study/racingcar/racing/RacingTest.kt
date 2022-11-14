package study.racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.car.CarFactory

internal class RacingTest {
    @Test
    fun `자동차가 전진을 한다면 전진한 값을 반환한다`() {
        val generatorStub = GeneratorStub()

        val racing = Racing(CarFactory.createCars(2), generatorStub)
        assertThat(racing.attempt()).isEqualTo(listOf(2, 2))
    }
}
