package racingcar

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputTest {
    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5])
    fun `자동차 대수가 2 이상이면 validateNumberOfCars 에 성공한다`(input: Int) {
        Assertions.assertDoesNotThrow { validateNumberOfCars(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 0])
    fun `자동차 대수가 2 미만이면 validateNumberOfCars 에 실패한다`(input: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { validateNumberOfCars(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `시도할 횟수가 1 이상이면 validateNumberOfGames 에 성공한다`(input: Int) {
        Assertions.assertDoesNotThrow { validateNumberOfGames(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `시도할 횟수가 1 미만이면 validateNumberOfGames 에 실패한다`(input: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { validateNumberOfGames(input) }
    }
}
