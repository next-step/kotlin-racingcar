package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class CarCollectionTest {

    @Test
    @DisplayName("기준 숫자인 4이상의 값과 매칭되는 차는 이동한다")
    fun tryMoveCars() {
        val numberOfCar = 5
        val conditionNumbers = arrayListOf(0, 2, 4, 6, 8)

        val carCollection = CarCollection(numberOfCar)
        carCollection.tryMoveCars(conditionNumbers)

        assertThat(carCollection.getCarsPosition()).containsSequence(0, 0, 1, 1, 1)
    }
}
