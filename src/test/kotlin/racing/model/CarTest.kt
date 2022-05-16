package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @Test
    fun `create default car`() {
        //given
        val expected = "-"

        //when
        val result = Car().position

        //then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `toString test`() {
        //given
        val expected = "-"

        //when
        val result = Car().toString()

        //then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5])
    fun `go test`(loop: Int) {
        //given
        val expected = "-".repeat(loop)

        //when
        val result = List(loop - 1) { it }
            .fold(Car()) { acc, _ -> acc.go()}
            .toString()

        //then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5])
    fun `goOrNot test`(targetNumber: Int) {
        //given
        val car = Car()
        val goOrNotNumber = checkGoOrNot(targetNumber)
        val expected = "-".repeat(goOrNotNumber)

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