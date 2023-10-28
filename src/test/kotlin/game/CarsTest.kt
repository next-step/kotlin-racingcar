package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = ["1,4,1", "2,5,2", "3,6,3", "4,7,4", "5,8,5", "6,9,6"])
    fun `조건이 모두 4이상 9이하이면 시도할 횟수만큼 이동한다`(carCount: Int, fixedMoveCondition: Int, retryCount: Int) {
        // given
        val cars = Cars.fromCarCount(carCount, FixedMoveConditionGenerator(fixedMoveCondition))

        // when
        cars.advance(retryCount, UserMessageDisplay::display)
        val carList = cars.carList

        // then
        Assertions.assertAll(
            { assertThat(carList).hasSize(carCount) },
            { assertThat(carList.filter { car: Car -> car.isSamePosition(retryCount) }).hasSize(carCount) }
        )
    }

    @ParameterizedTest
    @CsvSource(value = ["1,3,3", "6,10,5"])
    fun `조건이 모두 4미만 혹은 9초과이면 시도회수와 관계없이 움직이지 않는다`(carCount: Int, fixedMoveCondition: Int, retryCount: Int) {
        // given
        val cars = Cars.fromCarCount(carCount, FixedMoveConditionGenerator(fixedMoveCondition))

        // when
        cars.advance(retryCount, UserMessageDisplay::display)
        val carList = cars.carList

        // then
        Assertions.assertAll(
            { assertThat(carList).hasSize(carCount) },
            { assertThat(carList.filter { car: Car -> car.isSamePosition(0) }).hasSize(carCount) }
        )
    }
}
