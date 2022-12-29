package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import util.racing.generator.NumberGenerator

class CarsTest {

    @DisplayName("4이상이면 차들이 움직인다")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun moveTest(moveNumber: Int) {
        val cars = Cars.of(3)

        cars.move(object : NumberGenerator {
            override fun generate(): Int {
                return moveNumber
            }
        })

        val result = cars.toResult()

        result.values.forEach { assertThat(it).isEqualTo("-") }
    }

    @DisplayName("4미만이면 차들이 안움직인다")
    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun notMoveTest(moveNumber: Int) {
        val cars = Cars.of(3)

        cars.move(object : NumberGenerator {
            override fun generate(): Int {
                return moveNumber
            }
        })

        val result = cars.toResult()

        result.values.forEach { assertThat(it).isEqualTo("") }
    }
}
