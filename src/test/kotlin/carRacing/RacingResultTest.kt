package carRacing

import carRacing.domain.Car
import carRacing.domain.CarList
import carRacing.domain.RacingResult
import carRacing.serviceimpl.RandomMovementController
import carRacing.testcontroller.TestFalseMovementController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class RacingResultTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 List 값은 초기화 할 수 없다`(carHistoryList: MutableList<CarList>) {
        assertThrows<IllegalArgumentException> {
            RacingResult(carHistoryList)
        }
    }

    @Test
    fun `RacingResult add 함수로 새로운 Racing 스냅샷을 추가할 수 있다`() {
        val carList: CarList = CarList(mutableListOf(Car("a", RandomMovementController())))
        val racingResult: RacingResult = RacingResult(mutableListOf(carList))

        racingResult.add(CarList(mutableListOf(Car("b", RandomMovementController()))))

        assertThat(racingResult.getRacingResultHistory().size).isEqualTo(2)
    }

    @Test
    fun `getRacingResultHistory 스냅샷이 담긴 CarList List를 반환한다`() {
        val carList: CarList = CarList(mutableListOf(Car("a", RandomMovementController())))
        val racingResult: RacingResult = RacingResult(mutableListOf(carList))

        val resultHistory: List<CarList> = racingResult.getRacingResultHistory()
        assertThat(racingResult.getRacingResultHistory()).isInstanceOf(List::class.java)
        resultHistory.forEach {
            assertThat(it).isInstanceOf(CarList::class.java)
        }
    }

    @Test
    fun `getWinnerNames 최종적으로 승리한 유저들의 이름을 반환합니다`() {
        val cars: MutableList<Car> = mutableListOf(
            Car("aa", TestFalseMovementController(), 3),
            Car("bb", TestFalseMovementController(), 2),
            Car("cc", TestFalseMovementController(), 1)
        )

        val racingResult: RacingResult = RacingResult(mutableListOf(CarList(cars)))

        assertThat(racingResult.getWinnerNames()).containsExactly("aa")
    }
}
