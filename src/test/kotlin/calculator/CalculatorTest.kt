package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream
import kotlin.collections.Map.Entry

class CalculatorTest {

    companion object {
        @JvmStatic
        fun createBlankStrings(): Stream<String> {
            return Stream.of(null, "", "   ");
        }

        @JvmStatic
        fun createCalculation(): Stream<AbstractMap.SimpleEntry<String, Int>> {
            return Stream.of(
                AbstractMap.SimpleEntry("3 + 5", 8),
                AbstractMap.SimpleEntry("3 - 5", -2),
                AbstractMap.SimpleEntry("3 * 5", 15),
                AbstractMap.SimpleEntry("15 / 3", 5),


                AbstractMap.SimpleEntry("3 + 5 - 2", 6),
                AbstractMap.SimpleEntry("3 - 5 * 3", -6),
                AbstractMap.SimpleEntry("3 * 5 + 2", 17),
                AbstractMap.SimpleEntry("15 / 3 - 5", 0),


                AbstractMap.SimpleEntry("3 + 5 - 2 * 7", 42),
                AbstractMap.SimpleEntry("3 - 5 * 3 / 2", -3),
                AbstractMap.SimpleEntry("3 * 5 + 2 - 10", 7),
                AbstractMap.SimpleEntry("15 / 3 - 5 + 100", 100)


            );
        }
    }

    @ParameterizedTest
    @MethodSource("createBlankStrings")
    fun `계산시 계산식이 공백 또는 null이면 Exception`(input : String?) {
        val calculator = Calculator(input);

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(); }
    }

    @ParameterizedTest
    @MethodSource("createCalculation")
    fun `전체적인 계산식 테스트`(entry : Entry<String, Int>) {
        val expression = entry.key;
        val except = entry.value;
        val calculator = Calculator(expression);

        assertThat(calculator.calculate())
            .isEqualTo(except)
    }
}