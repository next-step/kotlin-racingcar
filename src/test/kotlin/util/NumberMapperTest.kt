package util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class NumberMapperTest {

    @Test
    fun `null 값은 Int로 변환할 수 없다`() {
        // given & when
        val executable = Executable {
            (null as String?).toIntOrThrow()
        }

        // then
        assertThrows(NullPointerException::class.java, executable)
    }

    @Test
    fun `Int가 아닌 문자열을 변환할 수 없다`() {
        // given & when
        val executable = Executable {
            ("NoIntTypeString").toIntOrThrow()
        }

        // then
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun `String_toIntOrThrow() 기능 테스트`() {
        // given & when
        val expected = "5".toInt()
        val actual = "5".toIntOrThrow()

        // then
        assertEquals(expected, actual)
    }
}
