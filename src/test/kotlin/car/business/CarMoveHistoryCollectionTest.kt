package car.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveHistoryCollectionTest {
    @Test
    fun `최고점수를 가진 Car를 리턴할 줄 알아야 한다`() {
        val histories: MutableList<CarMoveHistory> = ArrayList()

        histories.add(CarMoveHistory(CarName("오"), 1))
        histories.add(CarMoveHistory(CarName("길"), 2))
        histories.add(CarMoveHistory(CarName("환"), 3))
        histories.add(CarMoveHistory(CarName("이"), 4))
        histories.add(CarMoveHistory(CarName("다"), 4))

        val historyCollection = CarMoveHistoryCollection(histories)

        val frontHistories = historyCollection.getWinners()

        assertThat(frontHistories.map { it.carName })
            .containsExactly(CarName("이"), CarName("다"))
    }
}
