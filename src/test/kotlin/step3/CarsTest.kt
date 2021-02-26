package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `자동차 일급컬랙션을 생성할 수 있다`() {
        assertThat(Cars(3)).isEqualTo(Cars(3))
    }

    @Test
    fun `이동후 위치목록을 제공한다`() {
        val cars = testCars(3)
        cars.drive()
        cars.drive()
        assertThat(cars.positions).containsExactly(Position(2), Position(2), Position(2))
    }

    data class Positions(private val positions: List<Position>) : List<Position> by positions {
        constructor(vararg positions: Int) : this(positions.map(::Position))

        fun add(position: Position): Positions {
            return Positions(positions + position)
        }

        operator fun plus(position: Position) = Positions(positions + position)
    }

    data class Cars(private val cars: List<Car>) {
        constructor(cars: Int) : this((0 until cars).map { Car() })

        var positions = Positions()

        fun drive() {
            positions = cars.map { it.driving() }
                .fold(Positions(), Positions::plus)
        }
    }

    private fun testCars(count: Int) = Cars((0 until count).map { Car(moveable = Moveable.Always()) })
}
