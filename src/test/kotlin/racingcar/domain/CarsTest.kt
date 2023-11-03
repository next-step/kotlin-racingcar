package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

private const val MOVE = 4
private const val STOP = 3

class CarsTest {

    @Test
    fun `차량은 생성 시 위치를 0으로 초기화한다`() {
        val cars = Cars(createStubRandomGenerator(), listOf("a", "b", "c", "d", "e"))

        Assertions.assertThat(cars.positions)
            .isEqualTo(
                Positions(
                    Position("a", 0),
                    Position("b", 0),
                    Position("c", 0),
                    Position("d", 0),
                    Position("e", 0),
                )
            )
    }

    @Test
    fun `여러 차량 생성 후 이동 및 정지`() {
        val cars = Cars(createStubRandomGenerator(MOVE, STOP, MOVE), listOf("a", "b", "c"))

        cars.move()

        Assertions.assertThat(cars.positions)
            .isEqualTo(
                Positions(
                    Position("a", 1),
                    Position("b", 0),
                    Position("c", 1),
                )
            )
    }

    @Test
    fun `여러 차량 생성 후 여러번 이동 및 정지`() {
        val numbers = listOf(
            "a" to listOf(MOVE, STOP, MOVE),
            "b" to listOf(STOP, STOP, MOVE),
            "c" to listOf(MOVE, MOVE, MOVE),
        ).flatMap { it.second }
        val cars = Cars(createStubRandomGenerator(numbers), listOf("a", "b", "c"))

        cars.move()
        cars.move()
        cars.move()

        Assertions.assertThat(cars.positions)
            .isEqualTo(
                Positions(
                    Position("a", 2),
                    Position("b", 1),
                    Position("c", 3),
                )
            )
    }
}
