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
}
