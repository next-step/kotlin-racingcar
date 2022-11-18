package racingcarWinner.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinnerTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10, Int.MAX_VALUE])
    fun `getWinner when winner is one`(maxMoveStep: Int) {
        val carNames = "pobi,crong,honux".split(",")
        val cars = Cars(carNames)
        val winnerIndex = 0

        // when
        val carList = cars.carList.map { car ->
            car.moveStep = maxMoveStep - 1
            car
        }
        carList[winnerIndex].moveStep = maxMoveStep
        val resultWinnerList = Winner.getWinner(cars)

        resultWinnerList.count() shouldBe 1
        resultWinnerList[winnerIndex] shouldBe carList[winnerIndex].carName
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10])
    fun `getWinner when winner more than one`(maxMoveStep: Int) {
        val carNames = "pobi,crong,honux".split(",")
        val cars = Cars(carNames)

        // when
        val carList = cars.carList.map { car ->
            car.moveStep = maxMoveStep
            car
        }
        val resultWinnerList = Winner.getWinner(cars)

        resultWinnerList.forEachIndexed { index, winnerName ->
            winnerName shouldBe carList[index].carName
        }
        resultWinnerList.count() shouldBe carList.count()
    }
}
