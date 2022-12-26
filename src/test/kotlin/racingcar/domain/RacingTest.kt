package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingTest {
    private val racing = Racing()

    @DisplayName(value = "들어온 숫자만큼 car를 움직인다")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun moveCar(num: Int) {
        val car = racing.makeCars(1)[0]
        (1..num).forEach { _ -> racing.move(car) }
        assertThat(car.distance).isEqualTo("-".repeat(num + 1))
    }

    @DisplayName(value = "들어온 숫자만큼 car를 만든다")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun makeCar(num: Int) {
        val cars = racing.makeCars(num)
        assertThat(cars.size).isEqualTo(num)
    }
}
