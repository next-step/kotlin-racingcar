package racingcarWinner.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen", "pobi , crong "])
    fun setCars(carNames: String) {
        val carNameList = carNames.split(",")
        val cars = Cars(carNameList).carList

        cars.count() shouldBe carNameList.count()
        cars.forEachIndexed { index, car ->
            car.carName shouldBe carNameList[index].trim()
            car.moveStep shouldBe 0
        }
    }
}
