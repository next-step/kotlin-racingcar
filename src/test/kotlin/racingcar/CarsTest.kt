package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `여러 차량 생성`() {
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
        val cars = Cars(createStubRandomGenerator(4, 3, 4), listOf("a", "b", "c"))

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
        val cars = Cars(createStubRandomGenerator(4, 3, 4, 3, 3, 4, 4, 4, 4), listOf("a", "b", "c"))

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
