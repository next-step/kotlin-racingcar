package racingcar.domain.winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.WinnerChecker
import racingcar.domain.Car

class WinnerCheckerTest {

    @Test
    fun `findWinners() 우승자가 한명인 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf(
                    Car("1", 5),
                    Car("2", 3),
                    Car("3", 1)
                )
            )
        ).isEqualTo(
            listOf(Car("1", 5))
        )
    }

    @Test
    fun `findWinners() 우승자가 여러명인 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf(
                    Car("1", 5),
                    Car("2", 5),
                    Car("3", 5)
                )
            )
        ).isEqualTo(
            listOf(
                Car("1", 5),
                Car("2", 5),
                Car("3", 5)
            )
        )
    }

    @Test
    fun `findWinners() 전부다 움직인 적 없는 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf(
                    Car("1", 0),
                    Car("2", 0),
                    Car("3", 0)
                )
            )
        ).isEqualTo(
            listOf(
                Car("1", 0),
                Car("2", 0),
                Car("3", 0)
            )
        )
    }

    @Test
    fun `findWinners() 차가 없는 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf()
            )
        ).isEqualTo(
            listOf<Car>()
        )
    }
}
