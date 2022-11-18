package racingcarWinner.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcarWinner.util.MessageCode

internal class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen", "pobi , crong "])
    fun `cars init`(carNames: String) {
        val carNameList = carNames.split(",")
        val cars = Cars(carNameList).carList

        cars.count() shouldBe carNameList.count()
        cars.forEachIndexed { index, car ->
            car.carName shouldBe carNameList[index].trim()
            car.moveStep shouldBe 0
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "alen"])
    fun `cars init throw Exception when carNumber is one`(carNames: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Cars(carNames.split(","))
        }

        assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 10, Int.MAX_VALUE])
    fun findMaxMoveStepCarNameList(maxMoveStep: Int) {
        val carNames = "pobi,crong,honux".split(",")
        val cars = Cars(carNames)
        val winnerIndex = 0

        // when
        val carList = cars.carList.map { car ->
            car.moveStep = maxMoveStep - 1
            car
        }
        carList[winnerIndex].moveStep = maxMoveStep

        val resultCarNameList = cars.findMaxMoveStepCarNameList()

        resultCarNameList.count() shouldBe 1
        resultCarNameList[winnerIndex] shouldBe carList[winnerIndex].carName
    }
}
