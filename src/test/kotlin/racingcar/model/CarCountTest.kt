package racingcar.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class CarCountTest {

    @Test
    fun `CarCount는 최소 1이상이어야 한다`() {
        // given & when
        val executable = Executable { CarCount(-1) }

        // then
        assertThrows(IllegalArgumentException::class.java, executable)
    }
}
