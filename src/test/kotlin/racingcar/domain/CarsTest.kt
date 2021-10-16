package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {
    @DisplayName("NumberGenerator 가 4 이상인 숫자를 생성하면, 자동차들이 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `전진 가능`(number: Int) {
        val numberGenerator = object : NumberGenerator {
            override fun getNumber() = number
        }
        val cars = Cars(numberGenerator, listOf(Car("pyro"), Car("jason"), Car("nath")))

        val moveNumber = 5
        repeat(moveNumber) { cars.move() }
        assertThat(cars.exportResult())
            .isEqualTo(mapOf("pyro" to moveNumber, "jason" to moveNumber, "nath" to moveNumber))
    }

    @DisplayName("NumberGenerator 가 4 미만인 숫자를 생성하면, 자동차들이 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `전진 불가능`(number: Int) {
        val numberGenerator = object : NumberGenerator {
            override fun getNumber() = number
        }
        val cars = Cars(numberGenerator, listOf(Car("pyro"), Car("jason"), Car("nath")))

        val moveNumber = 5
        repeat(moveNumber) { cars.move() }
        assertThat(cars.exportResult())
            .isEqualTo(mapOf("pyro" to DEFAULT_POSITION, "jason" to DEFAULT_POSITION, "nath" to DEFAULT_POSITION))
    }

    @DisplayName("position 이 가장 먼 사람이 우승자이다.")
    @Test
    fun `한명의 우승자`() {
        val numberGenerator = object : NumberGenerator {
            override fun getNumber() = 9
        }
        val cars = Cars(
            numberGenerator, listOf(
                Car("pyro", 3),
                Car("jason", 5),
                Car("nath", 4)
            )
        )

        assertThat(cars.exportWinners())
            .isEqualTo(listOf("jason"))
    }

    @DisplayName("우승자의 position 이 같다면, 우승자는 한 명 이상일 수 있다.")
    @Test
    fun `여러 명의 우승자`() {
        val numberGenerator = object : NumberGenerator {
            override fun getNumber() = 9
        }
        val cars = Cars(
            numberGenerator, listOf(
                Car("pyro", 5),
                Car("jason", 4),
                Car("nath", 5)
            )
        )

        assertThat(cars.exportWinners())
            .isEqualTo(listOf("pyro", "nath"))
    }

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
