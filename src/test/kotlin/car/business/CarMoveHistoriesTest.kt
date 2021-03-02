package car.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveHistoriesTest {
    @Test
    fun `최고점수를 가진 Car를 리턴할 줄 알아야 한다`() {
        val histories = CarMoveHistories()
        histories.add(CarMoveHistory(Car("오"), 1))
        histories.add(CarMoveHistory(Car("길"), 2))
        histories.add(CarMoveHistory(Car("환"), 3))
        histories.add(CarMoveHistory(Car("이"), 4))
        histories.add(CarMoveHistory(Car("다"), 4))

        val frontHistories = histories.getFrontHistories()

        assertThat(frontHistories.map { it.car.name })
            .containsExactly("이", "다")
    }
}