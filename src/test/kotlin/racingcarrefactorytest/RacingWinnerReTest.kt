package racingcarrefactorytest

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcarwinner.domain.Car
import racingcarwinner.domain.RacingGame

import org.assertj.core.api.Assertions.assertThat

class RacingWinnerReTest {

    @Test
    @DisplayName("이름과 진행사항 저장")

    fun cars() {
        val carlist = listOf<Car>(
            Car("joseph"),
            Car("jason"),
            Car("happy")
        )

        for (cartest in carlist) {
            assertThat(cartest.position.toInt()).isEqualTo(0)
            cartest.moveSample(3)
            assertThat(cartest.position.toInt()).isEqualTo(0)
            cartest.moveSample(7)
            assertThat(cartest.position.toInt()).isEqualTo(1)
        }
    }

    /*
        @Test
        @DisplayName("최대값 찾")
        fun racingmaxTest() {
            val carlist = listOf<Car>(
                Car("joseph", 4),
                Car("jason", 5),
                Car("happy", 7)
            )
            val max = RacingGame(carlist).maximumPosition()
            assertThat(max).isEqualTo(7)
        }

        @Test
        @DisplayName("우승자 찾기")
        fun racingWinner() {
            val carList = listOf<Car>(
                Car("joseph", 4),
                Car("jason", 5),
                Car("happy", 7)
            )
            val winners = RacingGame(carList).findWinner()

            assertThat(winners).isEqualTo(mutableListOf(carList.maxBy { it.position }))
        }

     */
    @Test
    @DisplayName("분")
    fun `splitTest`() {
        val carList = "joseph,jason,happy"
        val car = RacingGame(carList)
        assertThat(car.cars.map { car -> car.name }).isEqualTo(
            mutableListOf(
                Car("joseph").name,
                Car("jason").name,
                Car("happy").name
            )
        )
    }
}
