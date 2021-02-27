package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*
import java.util.stream.Stream

class CalculatorTest {

    companion object {
        @JvmStatic
        fun createBlankStrings(): Stream<String> {
            return Stream.of(null, "", "   ");
        }
    }

    @ParameterizedTest
    @MethodSource("createBlankStrings")
    fun `계산시 계산식이 공백 또는 null이면 Exception`(input : String?) {
        val calculator = Calculator(input);

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { calculator.calc(); }
    }
}