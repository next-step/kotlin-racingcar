package carracing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class Test {

    @ParameterizedTest
    @ValueSource(strings = ["pooh,tiger,ryan,", ",pooh,tiger,ryan", "1,2"])
    fun `parsing car name error`(carNames: String) {
        assertThatThrownBy { CarRacing(carNames, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `parsing car name`() {
        CarRacing("test,a,b", 0)
    }

    @Test
    fun `check null and blank for parsing`() {
        assertThatThrownBy { CarRacing("", 0) }.isInstanceOf(NullPointerException::class.java)
    }

    @Test
    fun `check invalid string`() {
        assertThatThrownBy { CarRacing("pooh&tiger", 0) }.isInstanceOf(CarRacingException::class.java)
    }

    @Test
    fun `check end string`() {
        assertThatThrownBy { CarRacing("pooh,", 0) }.isInstanceOf(CarRacingException::class.java)
    }

    @Test
    fun `check max length for car name`() {
        assertThatThrownBy { CarRacing("tigger", 0) }.isInstanceOf(CarRacingException::class.java)
    }

    @Test
    fun `find winners`() {
        val carRacing = CarRacing(
            listOf(
                Car("pooh", 3),
                Car("hello", 1),
                Car("qoo", 3)
            )
        )
        assertThat(carRacing.findWinners()).containsExactlyInAnyOrder(
            Car("pooh", 3),
            Car("qoo", 3)
        )
    }

    @Test
    fun `move or stop`() {
        val carRacing = CarRacing("pooh,tiger,ryan", 0)
        carRacing.race()
    }

    @Test
    fun `move`() {
        val carRacing = CarRacing("pooh,tiger,ryan", 0)
        val car = carRacing.race()[0]
        val position = car.position
        car.move()
        assertThat(car.position).isGreaterThanOrEqualTo(position)
    }
}
