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
                    RacingCar(CarName("fac"), 4),
                    RacingCar(CarName("fac2"), 3)
                )
            )
        )
        result.saveRacingResult(
            RacingCars(
                listOf(
                    RacingCar(CarName("fac"), 5),
                    RacingCar(CarName("fac2"), 4)
                )
            )
        )

        Assertions.assertThat(result.racingResultList[0].carList).isEqualTo(
            listOf(
                RacingCar(CarName("fac"), 4),
                RacingCar(CarName("fac2"), 3)
            )
        )
        Assertions.assertThat(result.racingResultList[1].carList).isEqualTo(
            listOf(
                RacingCar(CarName("fac"), 5),
                RacingCar(CarName("fac2"), 4)
            )
        )
    }
}
