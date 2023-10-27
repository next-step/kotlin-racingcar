package study.racingcar.application

import org.junit.jupiter.api.Test
import study.racingcar.domain.RacingCar

class ResultViewTest {

    @Test
    fun showResult() {
        // given
        val racingCars = listOf(
            RacingCar("test1", 1),
            RacingCar("test2", 2),
            RacingCar("test3", 3)
        )

        // when
        ResultView.showResult(racingCars)

        // then
        // no exception
    }
}
