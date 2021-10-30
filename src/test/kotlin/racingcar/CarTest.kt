package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [2, 1, 3])
    fun `우승자가 1명 이상이면 validateWinnersCount 에 성공한다`(input: Int) {
        Assertions.assertDoesNotThrow { validateWinnersCount(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `우승자가 1명 미만이면 validateWinnersCount 에 실패한다`(input: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { validateWinnersCount(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7])
    fun `0에서 9사이의 랜덤 값이 4 이상일 경우 전진한다`(input: Int) {
        val car = Car()
        car.move(input)
        assertThat(car.position).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `0에서 9사이의 랜덤 값이 4 미만일 경우 멈춘다`(input: Int) {
        val car = Car()
        car.move(input)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 11, 10])
    fun `전진 시도 숫자가 0과 9사이의 값이 아니면 validateAttemptNumber 에 실패한다`(input: Int) {
        val car = Car()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { car.validateAttemptNumber(input) }
    }
}
