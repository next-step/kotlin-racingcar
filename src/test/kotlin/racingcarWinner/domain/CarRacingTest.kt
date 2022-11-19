package racingcarWinner.domain

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarRacingTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "pobi,crong,honux,alen"])
    fun startRacing(carNames: String) {
        val tryNumber = 3
        val carNameList = carNames.split(",")
        val cars = Cars(carNameList).carList

        val moveResult = CarRacing.startRacing(cars = cars)

        moveResult.count() shouldBe carNameList.count()
        moveResult.forEachIndexed { index, car ->
            car.carName shouldBe carNameList[index]
            car.moveStep shouldBeLessThanOrEqual tryNumber
        }
    }
}
