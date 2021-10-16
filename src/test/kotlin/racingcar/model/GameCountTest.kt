package racingcar.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class GameCountTest {

    @Test
    fun `GameCount 최소 1이상이어야 한다`() {
        // given & when
        val executable = Executable { GameCount(-1) }

        // then
        assertThrows(IllegalArgumentException::class.java, executable)
    }
}
