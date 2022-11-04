package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2,10","2 - 10 + 7 + 1 * 100,0"])
    fun `정상 입력값에서 계산시 결과값을 반환해야 합니다`(input:String,  expectedResult: Int) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expectedResult)
    }    
    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2 / 0","    "," ","","1 1 1","1 + +","떡볶이","*!@#_$@"])
    fun `비정상 입력값에서 계산시 예외를 던져야 합니다`(input:String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
