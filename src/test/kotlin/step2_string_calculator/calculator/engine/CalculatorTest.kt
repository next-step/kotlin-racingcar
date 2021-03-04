package step2_string_calculator.calculator.engine

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import step2_string_calculator.calculator.ui.Receiver

class MockReceiver : Receiver() {
    var answer: String? = ""
    override fun receive(): String? {
        print("수식을 입력해 주세요 : ")
        return answer
    }
}

internal class CalculatorTest {
    @Test
    fun addTest() {
        // given
        val mockReceiver = MockReceiver()
        mockReceiver.answer = "2 + 3"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun minusTest() {
        // given
        val mockReceiver = MockReceiver()
        mockReceiver.answer = "5 - 3"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun multiplyTest() {
        // given
        val mockReceiver = MockReceiver()
        mockReceiver.answer = "5 * 3"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun divideTest() {
        // given
        val mockReceiver = MockReceiver()
        mockReceiver.answer = "10 / 2"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun complexExpressionTest() {
        // given
        val mockReceiver = MockReceiver()
        mockReceiver.answer = "2 + 3 * 10 / 5"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        assertThat(result).isEqualTo(10)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun nullOrBlankTest(input: String?) {
        assertThatThrownBy {
            // given
            val mockReceiver = MockReceiver()
            mockReceiver.answer = input
            // when
            Calculator(receiver = mockReceiver).run()
        } // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("구문에 null 혹은 빈칸은 들어갈 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["!", "@", "#", "$"])
    fun operatorValidationTest(input: String?) {
        assertThatThrownBy {
            // given
            val mockReceiver = MockReceiver()
            mockReceiver.answer = "5 $input 3"
            // when
            Calculator(receiver = mockReceiver).run()
        } // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("은 허용 되지 않는 연산자입니다.")
    }
}
