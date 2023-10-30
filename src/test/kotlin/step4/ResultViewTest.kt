package step4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step4.data.RacingCar
import step4.presentation.ResultView

class ResultViewTest {
    @Test
    fun `getCarMoveView`() {
        Assertions.assertThat(ResultView.getCarMoveView(RacingCar("fac", 4)))
            .isEqualTo("fac : ----")
    }

    @Test
    fun `getFinalResultView`() {
        Assertions.assertThat(ResultView.getFinalResultView(listOf(RacingCar("fac", 4), RacingCar("marine", 4))))
            .isEqualTo("fac, marine가 최종 우승했습니다.")
    }
}
