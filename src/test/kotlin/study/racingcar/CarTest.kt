package study.racingcar

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `car name cannot exceed 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
        assertThat(exception.message).isEqualTo("Car name cannot exceed 5 characters")
    }
}
