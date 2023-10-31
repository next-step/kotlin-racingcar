package step4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step4.domain.CarName
import step4.domain.RacingCar
import step4.presentation.ResultView

class ResultViewTest {
    @Test
    fun `getCarMoveView 작동 여부 확인`() {
        Assertions.assertThat(
            ResultView.getCarMoveView(
                RacingCar(CarName("fac"), 4)
            )
        ).isEqualTo("fac : ----")
    }

    @Test
    fun `getFinalResultView 작동 여부 확인`() {
        Assertions.assertThat(
            ResultView.getFinalResultView(
                listOf(
                    RacingCar(CarName("fac"), 4),
                    RacingCar(CarName("marin"), 4)
                )
            )
        ).isEqualTo("fac, marin가 최종 우승했습니다.")
    }
}
