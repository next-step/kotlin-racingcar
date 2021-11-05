package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Cars
import racingcar.domain.IRandomNumberGenerator

class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `0에서 9사이의 랜덤 값이 4 이상일 경우 전진한다`(input: Int) {
        val customRandomNumberNumberGenerator = object : IRandomNumberGenerator {
            override fun getGeneratedNumber(): Int {
                return input
            }
        }
        val cars = Cars(listOf("car1", "car2"), customRandomNumberNumberGenerator)
        cars.move()
        cars.getCarsNameWithPosition().values.forEach { position -> assertThat(position).isEqualTo(2) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `0에서 9사이의 랜덤 값이 4 미만일 경우 멈춘다`(input: Int) {
        val customRandomNumberNumberGenerator = object : IRandomNumberGenerator {
            override fun getGeneratedNumber(): Int {
                return input
            }
        }
        val cars = Cars(listOf("car1", "car2"), customRandomNumberNumberGenerator)
        cars.move()
        cars.getCarsNameWithPosition().values.forEach { position -> assertThat(position).isEqualTo(1) }
    }
}
