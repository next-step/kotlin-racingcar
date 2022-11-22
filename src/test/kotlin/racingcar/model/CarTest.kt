package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["0:1", "3:1", "4:2", "9:2"], delimiter = ':')
    internal fun `점수가 4 이상이면 포지션 증가`(value: Int, expected: Int) {
        val car = Car.of("pobi")
        car.move(MoveFactor(value))
        assertThat(car.position.value).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    internal fun `범위를 넘어서는 점수가 들어오면 예외`(value: Int) {
        val car = Car.of("pobi")
        assertThrows<IllegalArgumentException> { car.move(MoveFactor(value)) }
    }

    @ParameterizedTest
    @CsvSource(value = ["3:5: 1", "0:100: 1", "4:5: 6", "9:99: 100"], delimiter = ':')
    internal fun `점수가 4 이상인 횟수만큼 포지션 증가`(value: Int, tryCount: Int, expected: Int) {
        val car = Car.of("pobi")
        repeat(tryCount) { car.move(MoveFactor(value)) }
        assertThat(car.position.value).isEqualTo(expected)
    }
}
