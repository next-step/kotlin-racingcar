package carracing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun `parsing car name`() {
        CarRacing("pooh,tiger,ryan")
    }

    @Test
    fun `check null and blank for parsing`() {
        assertThatThrownBy { CarRacing("") }.isInstanceOf(NullPointerException::class.java)
    }

    @Test
    fun `check invalid string`() {
        assertThatThrownBy { CarRacing("pooh&tiger") }.isInstanceOf(CarRacingException::class.java)
    }

    @Test
    fun `check end string`() {
        assertThatThrownBy { CarRacing("pooh,") }.isInstanceOf(CarRacingException::class.java)
    }

    @Test
    fun `check max length for car name`() {
        assertThatThrownBy { CarRacing("tigger") }.isInstanceOf(CarRacingException::class.java)
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
        val carRacing = CarRacing("pooh,tiger,ryan")
        carRacing.execute()
    }
}
