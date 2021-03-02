package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class CarConfigTest {

    @Test
    @DisplayName("지정한 수 만큼의 랜덤한 Integer List를 반환한다")
    fun randomNumberGenerator() {
        val numbers = CarConfig.randomNumberGenerator(10)
        assertThat(numbers.size).isEqualTo(10)
    }
}
