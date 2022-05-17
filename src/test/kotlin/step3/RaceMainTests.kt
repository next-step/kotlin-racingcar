package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RaceMainTests {

    @Test
    fun `trying toInt() from null`() {

        val a: Int? = null
        a?.toInt()
    }

}