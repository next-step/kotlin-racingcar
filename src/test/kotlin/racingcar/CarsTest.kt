package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `여러 차량 생성`() {
        val cars = Cars(createStubRandomGenerator(), 5).list()

        assertThat(cars)
            .hasSize(5)
            .flatExtracting({ it.position() })
            .containsExactly(0, 0, 0, 0, 0)
    }

    @Test
    fun `여러 차량 생성 후 이동 및 정지`() {
        val cars = Cars(createStubRandomGenerator(4, 3, 4), 3)

        cars.move()

        assertThat(cars.list())
            .flatExtracting({ it.position() })
            .containsExactly(1, 0, 1)
    }

    @Test
    fun `여러 차량 생성 후 여러번 이동 및 정지`() {
        val cars = Cars(createStubRandomGenerator(4, 3, 4, 3, 3, 4, 4, 4, 4), 3)

        cars.move()
        cars.move()
        cars.move()

        assertThat(cars.list())
            .flatExtracting({ it.position() })
            .containsExactly(2, 1, 3)
    }

    private fun createStubRandomGenerator(vararg values: Int): RandomGenerator {
        return object : RandomGenerator {
            private val numbers = values.iterator()

            override fun generate(): Int {
                return numbers.next()
            }
        }
    }
}
