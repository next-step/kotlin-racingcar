package domain.step3.domain.configuration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarConfigurationTest {

    @Test
    fun `자동차 수와, 라운드를 기반으로 설정을 만든다`() {
        val numberOfCars = NumberOfCars(1)
        val numberOfAttempts = NumberOfAttempts(1)
        val racingCarConfiguration = RacingCarConfiguration(numberOfCars, numberOfAttempts)

        assertAll(
            { assertThat(racingCarConfiguration).isNotNull },
            { assertThat(racingCarConfiguration).isExactlyInstanceOf(RacingCarConfiguration::class.java) }
        )
    }

    @Test
    fun `설정이 가지고 있는 값을 반환한다`() {
        val numberOfCars = NumberOfCars(1)
        val numberOfAttempts = NumberOfAttempts(1)
        val racingCarConfiguration = RacingCarConfiguration(numberOfCars, numberOfAttempts)

        assertAll(
            { assertThat(racingCarConfiguration.numberOfCars).isEqualTo(numberOfCars) },
            { assertThat(racingCarConfiguration.numberOfAttempts).isEqualTo(numberOfAttempts) }
        )
    }
}
