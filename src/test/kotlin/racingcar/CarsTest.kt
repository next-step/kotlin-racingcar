package racingcar

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `여러 차량 생성`() {
        val cars = Cars(createStubRandomGenerator(), createMockCarsListener(), 5).positions()

        assertThat(cars)
            .hasSize(5)
            .containsExactly(0, 0, 0, 0, 0)
    }

    @Test
    fun `여러 차량 생성 후 이동 및 정지`() {
        val carsListener = createMockCarsListener()
        val cars = Cars(createStubRandomGenerator(4, 3, 4), carsListener, 3)

        cars.move(1)

        assertThat(cars.positions())
            .containsExactly(1, 0, 1)
        verify(exactly = 1) { carsListener.listen(cars) }
    }

    @Test
    fun `여러 차량 생성 후 여러번 이동 및 정지`() {
        val carsListener = createMockCarsListener()
        val cars = Cars(createStubRandomGenerator(4, 3, 4, 3, 3, 4, 4, 4, 4), carsListener, 3)

        cars.move(3)

        assertThat(cars.positions())
            .containsExactly(2, 1, 3)
        verify(exactly = 3) { carsListener.listen(cars) }
    }

    private fun createStubRandomGenerator(vararg values: Int): RandomGenerator {
        val randomGenerator = mockk<RandomGenerator>()
        val numbers = values.iterator()
        every { randomGenerator.generate() }.answers { numbers.next() }
        return randomGenerator
    }

    private fun createMockCarsListener(): CarsListener {
        val carsListener = mockk<CarsListener>()
        every { carsListener.listen(any()) } just Runs
        return carsListener
    }
}
