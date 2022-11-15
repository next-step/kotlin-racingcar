package racingcarWinner.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinnerTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10, Int.MIN_VALUE])
    fun `getWinner when winner is one`(maxMoveStep: Int) {
        val carNames = "pobi,crong,honux".split(",")
        val winnerIndex = 0

        // when
        val cars = carNames.map { carName ->
            val car = Car(carName)
            car.moveStep = maxMoveStep - 1
            car
        }
        cars[winnerIndex].moveStep = maxMoveStep
        val resultWinnerList = Winner.getWinner(cars, maxMoveStep)

        resultWinnerList.count() shouldBe 1
        resultWinnerList[winnerIndex] shouldBe cars[winnerIndex].carName
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10])
    fun `getWinner when winner more than one`(maxMoveStep: Int) {
        val carNames = "pobi,crong,honux".split(",")

        // when
        val cars = carNames.map { carName ->
            val car = Car(carName)
            car.moveStep = maxMoveStep
            car
        }
        val resultWinnerList = Winner.getWinner(cars, maxMoveStep)

        resultWinnerList.forEachIndexed { index, winner ->
            winner shouldBe cars[index].carName
        }
        resultWinnerList.count() shouldBe cars.count()
    }
}
