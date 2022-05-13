package step3

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
internal class CarsTest {

    @MockK
    lateinit var movingStrategy: MovingStrategy

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `1) 자동차 개수 생성`(input: Int) {
        val cars = Cars.from(input)
        Assertions.assertThat(cars.carsList.size).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `2) 자동차 개수 생성 후 실행(이동 성공)`(input: Int) {
        val cars = Cars.from(input)
        every { movingStrategy.movable() } returns true
        cars.run(movingStrategy)
        for (i in 0 until input) {
            Assertions.assertThat(cars.carsList[i].getPosition()).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `3) 자동차 개수 생성 후 실행(이동 실패)`(input: Int) {
        val cars = Cars.from(input)
        every { movingStrategy.movable() } returns false
        cars.run(movingStrategy)
        for (i in 0 until input) {
            Assertions.assertThat(cars.carsList[i].getPosition()).isEqualTo(0)
        }
    }
}

