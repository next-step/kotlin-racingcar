package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

class CarTest {
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `전진하는 조건은 무작위 값이 4 이상 9미만일 경우 이다`(value: Int) {
        val car = Car(name = "glenn")
        val history = car.move(value)
        assertThat(history.position).isEqualTo(1)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `전진하지 않는 조건은 무작위 값이 0이상 3이하일 경우 이다`(value: Int) {
        assertThat(Car(name = "glenn").move(value).position).isEqualTo(0)
    }

    @CsvSource(
        value = [
            "4, 1",
            "4, 1",
            "6, 1",
            "1, 0",
        ]
    )
    @ParameterizedTest
    fun `정상 케이스 동작을 확인 한다`(value: String, expectPosition: Int) {
        val carHistory = value.split(" ").map { Car(name = "glenn").move(it.toInt()) }
        assertThat(carHistory.last().position).isEqualTo(expectPosition)
    }

    @Test
    fun `자동차의 이름을 부여한다`() {
        val car = Car(name = "glenn")
        assertThat(car.name).isEqualTo("glenn")
    }

    @ValueSource(strings = ["glennsm", "racingcar"])
    @ParameterizedTest
    fun `자동차의 이름은 5자를 초과할수 없다`(carName: String) {
        assertThrows<IllegalArgumentException> { Car(name = carName) }
    }
}
