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
        val cars = Cars.fromCarCount(carCount, fixedMoveConditionGenerator(fixedMoveCondition))

        // when
        cars.advance(retryCount)
        val positions = cars.carList.map(Car::position)

        // then
        Assertions.assertAll(
            { assertThat(positions).hasSize(carCount) },
            { assertThat(positions).containsOnly(retryCount) }
        )
    }

    @ParameterizedTest
    @CsvSource(value = ["1,3,3", "6,10,5"])
    fun `조건이 모두 4미만 혹은 9초과이면 시도회수와 관계없이 움직이지 않는다`(carCount: Int, fixedMoveCondition: Int, retryCount: Int) {
        // given
        val cars = Cars.fromCarCount(carCount, fixedMoveConditionGenerator(fixedMoveCondition))

        // when
        cars.advance(retryCount)
        val positions = cars.carList.map(Car::position)

        // then
        Assertions.assertAll({ assertThat(positions).hasSize(carCount) }, { assertThat(positions).containsOnly(0) })
    }

    private fun fixedMoveConditionGenerator(count: Int): MoveConditionGenerator = MoveConditionGenerator { count }
}
