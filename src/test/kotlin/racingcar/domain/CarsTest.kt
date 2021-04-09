package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.movestrategy.MoveStrategy
import racingcar.domain.movestrategy.RandomMoveStrategy

internal class CarsTest {

    private val moveStrategy = object : MoveStrategy {
        override fun movable() = true
    }

    private val notMoveStrategy = object : MoveStrategy {
        override fun movable() = false
    }

    @Test
    fun `elements numbers 사이즈가 다를 경우`() {
        val car1 = Car(Name("test"))
        val car2 = Car(Name("test"))
        assertThrows<IllegalArgumentException> { Cars(listOf(car1, car2)).move(listOf()) }
    }

    @Test
    fun `elements numbers 사이즈가 같을 경우`() {
        val car1 = Car(Name("test"))
        val car2 = Car(Name("test"))
        assertDoesNotThrow { Cars(listOf(car1, car2)).move(listOf(RandomMoveStrategy(), RandomMoveStrategy())) }
    }

    @Test
    fun `움직이지 않는 경우`() {
        val car1 = Car(Name("test"))
        val car2 = Car(Name("test"))
        val cars = Cars(listOf(car1, car2))
        val movedCars = cars.move(listOf(notMoveStrategy, notMoveStrategy))

        assertThat(cars).isEqualTo(movedCars)
    }

    @Test
    fun `움직이는 경우`() {
        val car1 = Car(Name("test"))
        val car2 = Car(Name("test"))
        val cars = Cars(listOf(car1, car2))
        val movedCars = cars.move(listOf(moveStrategy, moveStrategy))

        assertThat(cars).isNotEqualTo(movedCars)
        val movedCarDistance = movedCars.elements
            .map { it.distance }
        assertThat(movedCarDistance).contains(Distance(1))
    }

    @Test
    fun `최대 거리 계산`() {
        val car1 = Car(Name("test1"))
        val car2 = Car(Name("test"), Distance((1)))
        assertThat(Cars(listOf(car2, car1)).maxDistance).isEqualTo(Distance(1))
    }

    @Test
    fun `거리로 car 찾기`() {
        val car = Car(Name("test"))
        val car2 = Car(Name("test"), Distance((1)))
        val cars = Cars(listOf(car, car2))

        assertThat(cars.findAllByDistance(Distance())).contains(car)
        assertThat(cars.findAllByDistance(Distance(1))).contains(car2)
    }
}
