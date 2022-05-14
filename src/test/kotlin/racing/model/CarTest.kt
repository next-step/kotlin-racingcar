package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {

    @Test
    fun `create default car`() {
        val result = Car(name = "testName").position
        val expected = "-"

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `toString test`() {
        val result = Car(name = "testName").toString()
        val expected = "-"

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, testName",
        "2, testName",
        "3, testName",
        "4, testName",
        "5, testName",
    )
    fun `go test`(loop: Int, name: String) {

        val result = List(loop - 1) { it }
            .fold(Car(name)) { acc, _ -> acc.go()}
            .toString()
        val expected = "$name : " + "-".repeat(loop)

        assertThat(result).isEqualTo(expected)
    }
}