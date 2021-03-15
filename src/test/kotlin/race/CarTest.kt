package race

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import race.domain.Car

class CarTest {

    @Test
    fun `create car test`() {

        // GIVEN
        val name = "pobi"

        // WHEN
        val car = Car(name)

        // THEN
        assertThat(car).isNotNull
        assertThat(car.position).isEqualTo(0)
        assertThat(car.name).isEqualTo(name)
    }

    @Test
    fun `create cars test`() {

        // GIVEN
        val carNames = "pobi,crong"

        // WHEN
        val cars = Car.create(carNames)

        // THEN
        assertThat(cars.size).isEqualTo(2)
        assertThat(cars.map { it.name }).containsAll(carNames.split(Car.NAME_DELIMETER))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    fun `create cars names empty and blank test`(carNames: String) {
        Assertions.assertThatThrownBy { Car.create(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("carNames is not blank.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["  , ", " , ", "  ,  , "])
    fun `create cars names illegal test`(carNames: String) {
        Assertions.assertThatThrownBy { Car.create(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("name is not blank.")
    }

    @ParameterizedTest
    @CsvSource(
        value = ["-1:pobi", "10:crong"],
        delimiter = ':'
    )
    fun `illegal move condition range test`(input: Int, name: String) {
        Assertions.assertThatThrownBy { Car(name).move(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("condition is between 0 and 9.")
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["", " ", "     "])
    fun `name blank test`(name: String) {
        Assertions.assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("name is not blank.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["adsfsadf", "dfasderd", "dsfasdfasdfasdf"])
    fun `illegal name length test`(name: String) {
        Assertions.assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("name's length is lesser than or equals to 5.")
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "0:0:pobi",
            "1:0:crong",
            "2:0:honux",
            "3:0:pobi",
            "4:1:crong",
            "5:1:honux",
            "6:1:pobi",
            "7:1:crong",
            "8:1:honux",
            "9:1:pobi"
        ],
        delimiter = ':'
    )
    fun `move by condition test`(input: Int, position: Int, name: String) {

        // WHEN
        val movedCar = Car(name).move(input)

        // THEN
        assertThat(movedCar).isNotNull
        assertThat(movedCar.position).isEqualTo(position)
        assertThat(movedCar.name).isEqualTo(name)
    }
}
