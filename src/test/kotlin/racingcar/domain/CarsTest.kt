package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.movestrategy.FakeMoveStrategy
import racingcar.domain.movestrategy.FakeNotMoveStrategy

internal class CarsTest {

    private val car1 = Car("test")
    private val car2 = Car("test", 1)
    private val cars = Cars(listOf(car1))

    @Test
    fun `움직이지 않는 경우`() {
        val notMovedCars = cars.move(FakeNotMoveStrategy())

        assertThat(cars).isEqualTo(notMovedCars)
    }

    @Test
    fun `움직이는 경우`() {
        val movedCars = cars.move(FakeMoveStrategy())

        assertThat(movedCars.elements).allMatch { it.distance == Distance(1) }
    }

    @Test
    fun `최대 거리 계산`() {
        assertThat(Cars(listOf(car2, car1)).maxDistance).isEqualTo(Distance(1))
    }

    @Test
    fun `거리로 car 찾기`() {
        val cars = Cars(listOf(car2, car1))
        assertThat(cars.findAllByDistance(Distance())).contains(car1)
        assertThat(cars.findAllByDistance(Distance(1))).contains(car2)
    }
}
