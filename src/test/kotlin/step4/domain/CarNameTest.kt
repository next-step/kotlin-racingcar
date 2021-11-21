package step4.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

/**
 *
 * @author Leo
 */
class CarNameTest {

    @Test
    fun `이름 5자 초과 생성시 validation 검증`() {
        val invalidName = "abcde"
        val validName = "abcd"

        assertThatThrownBy { CarName(invalidName) }.isInstanceOf(IllegalArgumentException::class.java)
        assertDoesNotThrow { CarName(validName) }
    }
}
