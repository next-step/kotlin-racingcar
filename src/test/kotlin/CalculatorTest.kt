import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Nested
    @DisplayName("더하기")
    inner class AddTest {
        @Test
        fun 더하기() {
            val calculator = Calculator();

            val actual = calculator.add(1, 2);

            assertThat(actual).isEqualTo(3)
        }

        
    }


}
