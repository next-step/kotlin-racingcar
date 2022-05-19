package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

class CarTest {
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `전진하는 조건은 무작위 값이 4 이상 9미만일 경우 이다`(value: Int) {
        val car = Car()
        car.move(value)
        assertThat(car.position).isNotEqualTo(0)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `전진하지 않는 조건은 무작위 값이 0이상 3이하일 경우 이다`(value: Int) {
        val car = Car()
        car.move(value)
        assertThat(car.position).isEqualTo(0)
    }

    @CsvSource(
        value = [
            "4 3 2, 1",
            "4 6 2, 2",
            "6 6 5, 3",
            "1 1 2, 0"
        ]
    )
    @ParameterizedTest
    fun `정상 케이스 동작을 확인 한다`(value: String, expectPosition: Int) {
        val car = Car()
        value.split(" ").forEach { car.move(it.toInt()) }
        assertThat(car.position).isEqualTo(expectPosition)
        assertThat(car.histories.last().position).isEqualTo(expectPosition)
    }
}
