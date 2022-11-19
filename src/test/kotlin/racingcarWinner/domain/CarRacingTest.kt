package racingcarWinner.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcarWinner.util.MessageCode

internal class CarRacingTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen", "pobi , crong "])
    fun `cars init`(carNames: String) {
        val carNameList = carNames.split(",")
        val cars = CarRacing(carNameList).carList

        assertThat(cars.count()).isEqualTo(carNameList.count())
        cars.forEachIndexed { index, car ->
            assertThat(car.carName).isEqualTo(carNameList[index].trim())
            assertThat(car.getMoveStep()).isEqualTo(0)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "alen"])
    fun `cars init throw Exception when carNumber is one`(carNames: String) {
        val exception = assertThrows<IllegalArgumentException> {
            CarRacing(carNames.split(","))
        }

        assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen"])
    fun startRacing(carNames: String) {
        val tryNumber = 3
        val carNameList = carNames.split(",")
        val racing = CarRacing(carNameList)

        val moveResult = racing.startRacing()

        assertThat(moveResult.count()).isEqualTo(carNameList.count())
        moveResult.forEachIndexed { index, car ->
            assertThat(car.carName).isEqualTo(carNameList[index])
            assertThat(car.getMoveStep()).isLessThanOrEqualTo(tryNumber)
        }
    }
}
