package step4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step4.domain.CarName
import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.domain.RacingGameResultText

class RacingGameResultTextTest {
    @Test
    fun `saveMiddleResult 작동 여부 확인`() {
        val text = RacingGameResultText()
        text.saveMiddleResult(
            RacingCars(
                listOf(
                    RacingCar(CarName("fac"), 4),
                    RacingCar(CarName("fac2"), 3)
                )
            )
        )
        text.saveMiddleResult(
            RacingCars(
                listOf(
                    RacingCar(CarName("fac"), 5),
                    RacingCar(CarName("fac2"), 4)
                )
            )
        )
        Assertions.assertThat(text.middleResult[0]).isEqualTo(
            "fac : ----\n" + "fac2 : ---\n"
        )
        Assertions.assertThat(text.middleResult[1]).isEqualTo(
            "fac : -----\n" + "fac2 : ----\n"
        )
    }

    @Test
    fun `saveFinalResult 작동 여부 확인`() {
        val text = RacingGameResultText()
        text.saveFinalResultView(
            listOf(
                RacingCar(CarName("fac"), 4),
                RacingCar(CarName("marin"), 4)
            )
        )
        Assertions.assertThat(text.finalResult).isEqualTo("fac, marin가 최종 우승했습니다.")
    }
}
