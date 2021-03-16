package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import racingcar.history.RacingActionHistory

internal class CarCollectionTest {

    @Test
    @DisplayName("기준 숫자인 4이상의 값과 매칭되는 차는 이동한다")
    fun tryMoveCars() {
        val numberOfCar = 5
        val conditionNumbers = arrayListOf(0, 4, 8)

        val carCollection = CarCollection(numberOfCar)
        carCollection.tryMoveCars(1, conditionNumbers)

        val racingHistory = carCollection.getRacingHistories()[0].racingActionHistories

        assertThat(racingHistory).containsSequence(
            RacingActionHistory(0),
            RacingActionHistory(1),
            RacingActionHistory(1)
        )
    }
}
