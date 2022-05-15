package step3

import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@ExtendWith(MockKExtension::class)
internal class CarsTest {

    @MockK
    lateinit var movingStrategy: MovingStrategy

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
               "jay,kevin,evan,emma/ 4",
                delimiter = '/')
    fun `1) 자동차 개수 생성 후 실행(이동 성공)`(carNames: String, result: Int) {
        val cars = Cars.from(carNames)
        every { movingStrategy.movable() } returns true
        cars.run(movingStrategy)
        for (i in 0 until cars.carList.size) {
            Assertions.assertThat(cars.carList[i].position).isEqualTo(1)
        }
        Assertions.assertThat(cars.carList.size).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
               "jay,kevin,evan,emma/ 4",
                delimiter = '/')
    fun `2) 자동차 개수 생성 후 실행(이동 실패)`(carNames: String, result: Int) {
        val cars = Cars.from(carNames)
        every { movingStrategy.movable() } returns false
        cars.run(movingStrategy)
        for (i in 0 until cars.carList.size) {
            Assertions.assertThat(cars.carList[i].position).isEqualTo(0)
        }
        Assertions.assertThat(cars.carList.size).isEqualTo(result)
    }
}


