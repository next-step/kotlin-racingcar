package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `우승자가 1명 이상이면 validateWinnersCount 에 성공한다`() {
        val winners = listOf(Car("car1"), Car("car2"))
        Assertions.assertDoesNotThrow { validateWinnersCount(winners) }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7])
    fun `0에서 9사이의 랜덤 값이 4 이상일 경우 전진한다`(input: Int) {
        val car = Car("Nathan")
        car.move(input)
        assertThat(car.position).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `0에서 9사이의 랜덤 값이 4 미만일 경우 멈춘다`(input: Int) {
        val car = Car("Nathan")
        car.move(input)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 11, 10])
    fun `전진 시도 숫자가 0과 9사이의 값이 아니면 validateAttemptNumber 에 실패한다`(input: Int) {
        val car = Car("Nathan")
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { car.validateAttemptNumber(input) }
    }
}
