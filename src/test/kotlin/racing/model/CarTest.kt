package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @Test
    fun `create default car`() {
        val result = Car().position
        val expected = "-"

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `toString test`() {
        val result = Car().toString()
        val expected = "-"

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5])
    fun `go test`(loop: Int) {

        val result = List(loop - 1) { it }
            .fold(Car()) { acc, _ -> acc.go()}
            .toString()
        val expected = "-".repeat(loop)

        assertThat(result).isEqualTo(expected)
    }
}