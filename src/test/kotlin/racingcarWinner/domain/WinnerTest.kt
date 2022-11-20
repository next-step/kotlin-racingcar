package racingcarWinner.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinnerTest {

    lateinit var racing: CarRacing

    @BeforeEach
    fun setUp() {
        val carNames = "pobi,crong,honux".split(",")
        racing = CarRacing(carNames)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10, Int.MAX_VALUE])
    fun `getWinner when winner is one`(maxMoveStep: Int) {
        val winnerIndex = 0

        // when
        val carList = racing.getCarList().mapIndexed { index, car ->
            if (index == winnerIndex)car.move(10)
            car
        }
        val resultWinnerList = Winner(carList).getWinner()

        assertThat(resultWinnerList.count()).isEqualTo(1)
        assertThat(resultWinnerList[winnerIndex]).isEqualTo(carList[winnerIndex].carName)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10])
    fun `getWinner when winner more than one`(maxMoveStep: Int) {
        // when
        val carList = racing.getCarList().map { car ->
            car.move(10)
            car
        }
        val resultWinnerList = Winner(carList).getWinner()

        resultWinnerList.forEachIndexed { index, winnerName ->
            assertThat(winnerName).isEqualTo(carList[index].carName)
        }
        assertThat(resultWinnerList.count()).isEqualTo(carList.count())
    }
}
