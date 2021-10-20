package domain.step4.domain.configuration

import domain.step4.domain.racingcar.Names
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarConfigurationTest {

    @Test
    fun `자동차 수와, 라운드를 기반으로 설정을 만든다`() {
        val names = Names.ofStringWithSplitStrategy("a,b,c") { it.split(",") }
        val numberOfAttempts = NumberOfAttempts(1)
        val racingCarConfiguration = RacingCarConfiguration(names, numberOfAttempts)

        assertAll(
            { assertThat(racingCarConfiguration).isNotNull },
            { assertThat(racingCarConfiguration).isExactlyInstanceOf(RacingCarConfiguration::class.java) }
        )
    }

    @Test
    fun `설정이 가지고 있는 값을 반환한다`() {
        val names = Names.ofStringWithSplitStrategy("a,b,c") { it.split(",") }
        val numberOfAttempts = NumberOfAttempts(1)
        val racingCarConfiguration = RacingCarConfiguration(names, numberOfAttempts)

        assertAll(
            { assertThat(racingCarConfiguration.names).isEqualTo(names) },
            { assertThat(racingCarConfiguration.numberOfAttempts).isEqualTo(numberOfAttempts) }
        )
    }
}
