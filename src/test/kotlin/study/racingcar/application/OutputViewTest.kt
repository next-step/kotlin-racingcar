package study.racingcar.application

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import study.racingcar.domain.RacingCar

class OutputViewTest {

    // TODO-review : stdout 이기 때문에 테스트를 하지 않아도 되는 함수들인지 코멘트 부탁 드립니다!
    @Test
    @DisplayName("RacingCar 리스트를 입력 받아서 각 RacingCar 의 상태에 부합하는 UI 를 출력한다.")
    fun showResult() {
        // given
        val racingCars = listOf(
            RacingCar(CarName("test1"), 1),
            RacingCar(CarName("test2"), 2),
            RacingCar(CarName("test3"), 3)
        )

        // when
        OutputView().showResult(racingCars)

        // then
        // no exception
    }

    @Test
    @DisplayName("RacingCar 리스트를 입력 받아서 우승한 RacingCars 를 출력한다.")
    fun showWinners() {
        // given
        val racingCars = listOf(
            RacingCar(CarName("test1"), 1),
            RacingCar(CarName("test2"), 2),
            RacingCar(CarName("test3"), 3)
        )

        // when
        OutputView().showWinners(racingCars)

        // then
        // No Exception
    }
}
