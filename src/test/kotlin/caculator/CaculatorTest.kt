package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CaculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "-4 + 5=1.0",
            "2 - 5.5=-3.5",
            "4 * 9=36.0",
            "8 / 8=1.0",
            "3 + 9 / -6=-2.0",
            "7 - 6 + 2.5=3.5",
            "4 * -7 - 1=-29.0",
            "5 / -1 * 2=-10.0",
            "6 + 9 / -5 + 5=2.0",
            "6 - 4 * -7 + 5=-9.0",
            "-1 * 0 - 1 + 0=-1.0",
            "-4 / 8 + -1 + -5=-6.5",
            "  6 + 9   / -5 + 5=2.0",
            "6 - 4 *   -7 + 5  =-9.0",
            "   -1    * 0  -    1 + 0=-1.0",
            "     -4   /   8  +  -1 +  -5  =-6.5"
        ],
        delimiter = '='
    )
    fun test(input: String, result: Double) {
        assertThat(Caculator.calculate(input)).isEqualTo(result)
    }
}
