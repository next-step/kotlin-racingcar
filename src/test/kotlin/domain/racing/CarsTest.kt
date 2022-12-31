package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `4이상이면 차들이 움직인다`(moveNumber: Int) {
        val cars = Cars.of(listOf(Name("pobi"), Name("jason"), Name("marco")))

        cars.move { moveNumber }

        val result = cars.toResult()

        result.values.forEach { assertThat(it).isEqualTo("-") }
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `4미만이면 차들이 안움직인다`(moveNumber: Int) {
        val cars = Cars.of(listOf(Name("pobi"), Name("jason"), Name("marco")))

        cars.move { moveNumber }

        val result = cars.toResult()

        result.values.forEach { assertThat(it).isEqualTo("") }
    }
}
