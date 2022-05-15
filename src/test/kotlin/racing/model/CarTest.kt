package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {

    @Test
    fun `create default car`() {
        //given
        val expected = "-"

        //when
        val result = Car("testCar").position

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `toString test`() {
        //given
        val expected = "-"

        //when
        val result = Car("testCar").toString()

        //then
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
        //given
        val expected = "$name : " + "-".repeat(loop)

        //when
        val result = List(loop - 1) { it }
            .fold(Car(name)) { acc, _ -> acc.go()}
            .toString()

        //then
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
    fun `goOrNot test`(targetNumber: Int, name: String) {
        //given
        val car = Car(name)
        val goOrNotNumber = checkGoOrNot(targetNumber)
        val expected = "$name : " + "-".repeat(goOrNotNumber)

        //when
        val result = car
            .goOrNot(targetNumber)
            .toString()

        //then
        assertThat(result).isEqualTo(expected)
    }

    private fun checkGoOrNot(num: Int) =
        if (num >= 4) {
            2
        } else {
            1
        }
}