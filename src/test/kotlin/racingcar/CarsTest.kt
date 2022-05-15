package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `Cars move 책임 테스트`() {
        val cars = Cars(listOf(Car("a"), Car("b"), Car("c")))

        val moveStrategy = SuccessMoveStrategy()

        val movedCars = cars.move(moveStrategy)
        val move = movedCars.move(moveStrategy)

        assertThat(move.cars[0].position).isEqualTo(2)
    }

    @Test
    fun `Cars move 책임 테스트2`() {
        val cars = Cars(listOf(Car("a"), Car("b"), Car("c")))

        val successMoveStrategy = SuccessMoveStrategy()
        val failMoveStrategy = FailMoveStrategy()

        val movedCars = cars.move(successMoveStrategy)
        val move = movedCars.move(failMoveStrategy)

        assertThat(move.cars[0].position).isEqualTo(1)
    }
}
