package race

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import race.domain.Car

class CarTest {

    @Test
    fun `create car test`() {

        // WHEN
        val car = Car()

        // THEN
        assertThat(car).isNotNull
        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "10"])
    fun `illegal move condition range test`(input: Int) {
        Assertions.assertThatThrownBy { Car().move(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("condition is between 0 and 9.")
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "0:0",
            "1:0",
            "2:0",
            "3:0",
            "4:1",
            "5:1",
            "6:1",
            "7:1",
            "8:1",
            "9:1"
        ],
        delimiter = ':'
    )
    fun `move by condition test`(input: Int, position: Int) {

        // WHEN
        val movedCar = Car().move(input)

        // THEN
        assertThat(movedCar).isNotNull
        assertThat(movedCar.position).isEqualTo(position)
    }
}
