package step4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step4.domain.CarName
import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.domain.RacingGameResult

class RacingGameResultTest {
    @Test
    fun `saveRacingResult 작동 여부 확인`() {
        val result = RacingGameResult()
        result.saveRacingResult(
            RacingCars(
                listOf(
                    RacingCar(CarName(name = "fac"), moveCount = 4),
                    RacingCar(CarName(name = "fac2"), moveCount = 3)
                )
            )
        )
        result.saveRacingResult(
            RacingCars(
                listOf(
                    RacingCar(CarName(name = "fac"), moveCount = 5),
                    RacingCar(CarName(name = "fac2"), moveCount = 4)
                )
            )
        )

        Assertions.assertThat(result.racingResultList[0].carList).isEqualTo(
            listOf(
                RacingCar(CarName(name = "fac"), moveCount = 4),
                RacingCar(CarName(name = "fac2"), moveCount = 3)
            )
        )
        Assertions.assertThat(result.racingResultList[1].carList).isEqualTo(
            listOf(
                RacingCar(CarName(name = "fac"), moveCount = 5),
                RacingCar(CarName(name = "fac2"), moveCount = 4)
            )
        )
    }
}
