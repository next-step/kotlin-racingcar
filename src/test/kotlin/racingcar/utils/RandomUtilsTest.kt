package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RandomUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 9, 10])
    fun generateRandomNumber(maxNumber: Int) {
        // when
        val randomNumber = RandomUtils.getBetweenZeroAnd(maxNumber)

        // then
        assertThat(randomNumber).isGreaterThanOrEqualTo(0)
        assertThat(randomNumber).isLessThan(maxNumber)
    }
}
