package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["0:1", "3:1", "4:2", "9:2"], delimiter = ':')
    internal fun `점수가 4 이상이면 포지션 증가`(value: Int, expected: Int) {
        val car = Car("pobi")
        car.move(MoveFactor(value))
        assertThat(car.position.value).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    internal fun `범위를 넘어서는 점수가 들어오면 예외`(value: Int) {
        val car = Car("pobi")
        assertThrows<IllegalArgumentException> { car.move(MoveFactor(value)) }
    }

    @ParameterizedTest
    @CsvSource(value = ["3:5: 1", "0:100: 1", "4:5: 6", "9:99: 100"], delimiter = ':')
    internal fun `점수가 4 이상인 횟수만큼 포지션 증가`(value: Int, tryCount: Int, expected: Int) {
        val car = Car("pobi")
        repeat(tryCount) { car.move(MoveFactor(value)) }
        assertThat(car.position.value).isEqualTo(expected)
    }

    @Test
    internal fun `자동차에 이름을 부여한다`() {
        val name = "crong"
        val car = Car(name)
        assertThat(car.name).isEqualTo(name)
    }

    @Test
    internal fun `자동차의 이름은 5자를 초과할 수 없다`() {
        val name = "crongg"
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    internal fun `자동차의 이름은 공백이나 빈 문자열이 올 수 없다`(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }
}
