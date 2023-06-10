package study

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIOException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader

class AssertJTest {
    @Test
    fun `assertThatThrownBy 테스트`() {
        assertThatThrownBy {
            listOf("String one", "String two")[2]
        }.isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessageContaining("out of bounds for length 2")
    }

    @Test
    fun `assertThatExceptionOfType 테스트`() {
        assertThatExceptionOfType(IndexOutOfBoundsException::class.java)
            .isThrownBy {
                listOf("String one", "String two")[2]
            }.withMessageMatching("Index \\d+ out of bounds for length \\d+")
    }

    @Test
    fun `assertThatIOException 테스트`() {
        assertThatIOException().isThrownBy {
            val br = BufferedReader(InputStreamReader(System.`in`))
            br.close()
            br.readLine()
        }
    }
}
