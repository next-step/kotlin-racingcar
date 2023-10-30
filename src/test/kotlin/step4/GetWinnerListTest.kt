package step4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step4.domain.RacingCar
import step4.domain.GetWinnerList

class GetWinnerListTest {
    @Test
    fun `가장 높은 moveCount를 가진 차의 리스트를 뽑아준다`() {
        val racingCars1 = listOf(
            RacingCar("1", 1),
            RacingCar("2", 2),
            RacingCar("3", 3)
        )
        Assertions.assertThat(GetWinnerList.getWinnerList(racingCars1))
            .isEqualTo(listOf(RacingCar("3", 3)))
    }

    @Test
    fun `여러 개의 가장 높은 moveCount를 가진 차의 리스트를 뽑아준다`() {
        val racingCars1 = listOf(
            RacingCar("1", 3),
            RacingCar("2", 3),
            RacingCar("3", 1)
        )
        Assertions.assertThat(GetWinnerList.getWinnerList(racingCars1))
            .isEqualTo(
                listOf(
                    RacingCar("1", 3),
                    RacingCar("2", 3)
                )
            )
    }
}
