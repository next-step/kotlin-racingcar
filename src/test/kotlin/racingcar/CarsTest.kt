package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {
    @ParameterizedTest
    @CsvSource("4, 1", "1, 0")
    fun `4이상인 경우에만 전진을한다`(condition: Int, expectedCardPosition: Int) {
        val cars = Cars(ArrayList())

        val car = cars.forwardByCondition(Car(), condition)

        assertThat(car.position).isEqualTo(expectedCardPosition)
    }

    @Test
    fun `RacingCar 에 등록된 모든 자동차가 조건에 맞는 경우 전진한다`() {
        val cars = Cars(listOf(Car(), Car(), Car()))

        val forwardedCars = cars.forwardAllByCondition(listOf(1, 5, 9))

        assertAll(
            { assertThat(forwardedCars.getPositionByIndex(0)).isEqualTo(0) },
            { assertThat(forwardedCars.getPositionByIndex(1)).isEqualTo(1) },
            { assertThat(forwardedCars.getPositionByIndex(2)).isEqualTo(1) }
        )
    }

    @Test
    fun `필요한 자동차 개수만큼 자동차들이 만들어진다`() {
        val cars = Cars.createCars(3)

        assertAll(
            { assertThat(cars.getSize()).isEqualTo(3) },
            { assertThat(cars.getPositionByIndex(0)).isEqualTo(0) },
            { assertThat(cars.getPositionByIndex(1)).isEqualTo(0) },
            { assertThat(cars.getPositionByIndex(2)).isEqualTo(0) }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -5])
    fun `만들어야하는 자동차 개수가 0미만인 경우 예외처리한다`(numberOfCar: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Cars.createCars(numberOfCar)
        }.withMessageMatching("0미만의 개수는 생성할 수 없습니다.")
    }
}
