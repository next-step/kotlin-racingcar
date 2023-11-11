package carRacing

import carRacing.domain.Car
import carRacing.domain.CarList
import carRacing.domain.Racing
import carRacing.domain.RacingResult
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.testcontroller.TestFalseMovementController
import carRacing.testcontroller.TestTrueMovementController
import carRacing.view.CarInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `무조건 움직이는 전략과 무조건 멈추는 전략을 사용하는 자동차가 경주를 완료하면 무조건 움직이는 전략을 사용하는 자동차가 더 먼거리를 이동한다`(tryCount: Int) {
        val carInfoList: List<CarInfo> = listOf(
            CarInfo("a", TestTrueMovementController()),
            CarInfo("b", TestFalseMovementController())
        )

        val carList: List<Car> = RandomMovementCarFactory().createCars(carInfoList)

        val moveRacing = Racing(carList)

        val result: RacingResult = moveRacing.getRaceResult(tryCount)

        result.getRacingResultHistory().forEach { carList: CarList ->
            val currentCarList: List<Car> = carList.getCarList()

            assertThat(currentCarList[0].position).isGreaterThan(currentCarList[1].position)
        }
    }

    @Test
    fun `Position 값을 비교하여 우승자의 이름을 반환한다`() {
        val carInfoList: List<CarInfo> = listOf(
            CarInfo("a", TestTrueMovementController()),
            CarInfo("b", TestFalseMovementController())
        )

        val carList: List<Car> = RandomMovementCarFactory().createCars(carInfoList)

        val moveRacing = Racing(carList)

        val result: RacingResult = moveRacing.getRaceResult(1)

        assertThat(result.getWinnerNames()).isEqualTo(listOf("a"))
    }
}
