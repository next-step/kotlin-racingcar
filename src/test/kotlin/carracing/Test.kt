package carracing

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun `parsing car name`() {
        val carRacing = CarRacing("pooh,tiger,ryan")
    }

    @Test
    fun `check null and blank for parsing`() {
        assertThatThrownBy { CarRacing(null) }.isInstanceOf(NullPointerException::class.java)
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
}
