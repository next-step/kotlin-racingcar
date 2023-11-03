package carRacing

import carRacing.domain.Car
import carRacing.domain.Racing
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.testcontroller.TestFalseMovementController
import carRacing.testcontroller.TestTrueMovementController
import carRacing.view.CarInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class RacingTest {

    @ParameterizedTest
    @CsvSource("2, 1", "2, 2", "2, 3")
    fun `Racing 결과에서 반환하는 자동차 List의 길이는 carCount와 동일하다`(carCount: Int, tryCount: Int) {
        val moveRacing = Racing(RandomMovementCarFactory())
        val result: List<Car> = moveRacing.getRaceResult(carCount, tryCount)

        assertThat(result.size).isEqualTo(carCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `무조건 움직이는 전략과 무조건 멈추는 전략을 사용하는 자동차가 경주를 완료하면 무조건 움직이는 전략을 사용하는 자동차가 더 먼거리를 이동한다`(tryCount: Int) {
        val moveRacing = Racing(RandomMovementCarFactory())

        val carInfoList: List<CarInfo> = listOf(
            CarInfo("a", TestTrueMovementController()),
            CarInfo("b", TestFalseMovementController())
        )

        val result: List<Car> = moveRacing.getRaceResult(carInfoList, tryCount)

        assertThat(result[0].position).isGreaterThan(result[1].position)
    }
}
