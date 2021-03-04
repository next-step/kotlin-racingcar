package racingcar

import fixture.CarFixture.CAR_NAMES
import fixture.CarFixture.KIM_NAME
import fixture.CarFixture.LEE_NAME
import fixture.CarFixture.PACK_NAME
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarsTest {
    @ParameterizedTest
    @CsvSource("4, 1", "1, 0")
    fun `4이상인 경우에만 전진을한다`(condition: Int, expectedCardPosition: Int) {
        val cars = Cars(ArrayList())
        val car = Car(KIM_NAME)

        cars.forwardByCondition(car, condition)

        assertThat(car.position).isEqualTo(Position(expectedCardPosition))
    }

    @Test
    fun `RacingCar 에 등록된 모든 자동차가 조건에 맞는 경우 전진한다`() {
        val cars = Cars(listOf(Car(KIM_NAME), Car(PACK_NAME), Car(LEE_NAME)))

        cars.forwardAllByCondition(listOf(1, 5, 9))

        assertAll(
            { assertThat(cars.getPositionByIndex(0)).isEqualTo(Position(0)) },
            { assertThat(cars.getPositionByIndex(1)).isEqualTo(Position(1)) },
            { assertThat(cars.getPositionByIndex(2)).isEqualTo(Position(1)) }
        )
    }

    @Test
    fun `필요한 자동차 개수만큼 자동차들이 만들어진다`() {
        val cars = Cars.createCars(CAR_NAMES)

        assertAll(
            { assertThat(cars.getSize()).isEqualTo(3) },
            { assertThat(cars.getPositionByIndex(0)).isEqualTo(Position(0)) },
            { assertThat(cars.getPositionByIndex(1)).isEqualTo(Position(0)) },
            { assertThat(cars.getPositionByIndex(2)).isEqualTo(Position(0)) }
        )
    }

    @Test
    fun `만들어야하는 자동차 개수가 0미만인 경우 예외처리한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Cars.createCars(listOf())
        }.withMessageMatching("0 미만의 개수는 생성할 수 없습니다.")
    }

    @Test
    fun `경주가 끝난 후 우승자를 찾는다`() {
        val cars = Cars(listOf(Car(KIM_NAME), Car(PACK_NAME), Car(LEE_NAME)))

        cars.forwardAllByCondition(listOf(3, 5, 5))

        val winners = cars.findWinner()

        assertThat(winners.getSize()).isEqualTo(2)
        assertThat(winners.getByIndex(0)).isEqualTo(PACK_NAME)
        assertThat(winners.getByIndex(1)).isEqualTo(LEE_NAME)
    }
}
