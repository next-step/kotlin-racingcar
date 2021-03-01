package step2_string_calculator.calculator.engine

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import step2_string_calculator.calculator.ui.Receiver

internal class CalculatorTest {
    @Test
    fun addTest() {
        // given
        val mockReceiver = mockk<Receiver>()
        every { mockReceiver.run() } returns "2 + 3"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        verify { mockReceiver.run() }
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun minusTest() {
        // given
        val mockReceiver = mockk<Receiver>()
        every { mockReceiver.run() } returns "5 - 3"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        verify { mockReceiver.run() }
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun multiplyTest() {
        // given
        val mockReceiver = mockk<Receiver>()
        every { mockReceiver.run() } returns "5 * 3"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        verify { mockReceiver.run() }
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun divideTest() {
        // given
        val mockReceiver = mockk<Receiver>()
        every { mockReceiver.run() } returns "10 / 2"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        verify { mockReceiver.run() }
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun complexExpressionTest() {
        // given
        val mockReceiver = mockk<Receiver>()
        every { mockReceiver.run() } returns "2 + 3 * 10 / 5"

        // when
        val result = Calculator(receiver = mockReceiver).run()

        // then
        verify { mockReceiver.run() }
        assertThat(result).isEqualTo(10)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun nullOrBlankTest(input: String?) {
        assertThatThrownBy {
            // given
            val mockReceiver = mockk<Receiver>()
            every { mockReceiver.receive() } returns input
            every { mockReceiver.run() } returns Receiver().run()
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
            val mockReceiver = mockk<Receiver>()
            every { mockReceiver.run() } returns "5 $input 3"
            // when
            Calculator(receiver = mockReceiver).run()
        } // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("은 허용 되지 않는 연산자입니다.")
    }
}
