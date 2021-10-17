package racingcar.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class CarNameTest {

    @Test
    fun `CarName은 5자리를 초과할 수 없다`() {
        // given & when
        val executable = Executable {
            CarName("123456")
        }

        // then
        assertThrows(IllegalArgumentException::class.java, executable)
    }
}
