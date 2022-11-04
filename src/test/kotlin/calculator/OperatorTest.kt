package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,false","^,false","%,false","+,true","-,true"])
    fun `연산자인지 아닌지 판별해야 합니다`(input:String,expectedResult:Boolean) {
        assertThat(Operator.isOperator(input)).isEqualTo(expectedResult);
    }
    @ParameterizedTest
    @CsvSource(value = ["1,false","^,false","%,false","+,true","-,true"])
    fun `연산 기호에 적합한 연산자를 조회해야 합니다`(input:String,expectedResult:Boolean) {
        assertThat( Operator.valueOf(operator = input) != null).isEqualTo(expectedResult)
    }
}
