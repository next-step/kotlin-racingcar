package study.racingcar

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TokenTest {

    @Test
    fun `isInterpretableNumber should return true`() {
        // given
        val token = Token("*", "2231")

        // when
        val result = token.isInterpretableNumber()

        // then
        assertTrue(result)
    }

    @Test
    fun `isInterpretableNumber should return false`() {
        // given
        val token = Token("*", "1+")

        // when
        val result = token.isInterpretableNumber()

        // then
        assertFalse(result)
    }

    @Test
    fun isInterpretableOperator() {
        // given
        val token = Token("*", "1")

        // when
        val result = token.isInterpretableOperator()

        // then
        assertTrue(result)
    }
}
