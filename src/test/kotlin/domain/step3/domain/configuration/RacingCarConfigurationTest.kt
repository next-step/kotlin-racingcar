package domain.step3.domain.configuration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarConfigurationTest {

    @DisplayName("RacingCarConfiguration 생성 테스트")
    @Test
    fun constructor_test() {
        // given
        val numberOfCars = createTestNumberOfCars()
        val numberOfAttempts = createTestNumberOfAttempts()

        // when
        val racingCarConfiguration = RacingCarConfiguration(numberOfCars, numberOfAttempts)

        // then
        assertAll(
            { assertThat(racingCarConfiguration).isNotNull },
            { assertThat(racingCarConfiguration).isExactlyInstanceOf(RacingCarConfiguration::class.java) }
        )
    }
}