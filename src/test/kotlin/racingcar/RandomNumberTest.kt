package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RandomNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 9, 10])
    fun generateRandomNumber(maxNumber: Int) {
        // when
        val randomNumber = RandomNumber.getBetweenZeroAnd(maxNumber)

        // then
        assertThat(randomNumber).isGreaterThan(0)
        assertThat(randomNumber).isLessThan(maxNumber)
    }
}
