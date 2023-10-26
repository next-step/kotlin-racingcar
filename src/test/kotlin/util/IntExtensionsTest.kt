@file:Suppress("NonAsciiCharacters")

package util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IntExtensionsTest {
    @Test
    fun `isOdd - 홀수일 경우 true를 반환한다`() {
        val int = 1

        val result = int.isOdd()

        assertThat(result).isTrue()
    }

    @Test
    fun `isOdd - 짝수일 경우 false를 반환한다`() {
        val int = 2

        val result = int.isOdd()

        assertThat(result).isFalse()
    }

    @Test
    fun `isEven - 짝수일 경우 true를 반환한다`() {
        val int = 2

        val result = int.isEven()

        assertThat(result).isTrue()
    }

    @Test
    fun `isEven - 홀수일 경우 false를 반환한다`() {
        val int = 1

        val result = int.isEven()

        assertThat(result).isFalse()
    }
}
