package wk1_step4

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy

class WinnerCarRacingViewTest {
    @Test
    fun `자동차 이름이 없거나 null 인 경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.checkCarsValidation("")
        }.isInstanceOf(java.lang.NullPointerException::class.java)

        assertThatThrownBy {
            WinnerCarRacingView.checkCarsValidation(null)
        }.isInstanceOf(java.lang.NullPointerException::class.java)
    }

    @Test
    fun `자동차 이름에 영문, "," 외의 문자열이 포함될 경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.checkCarsValidation("test%ta")
        }.isInstanceOf(WinnerCarRacingException::class.java)
    }

    @Test
    fun `자동차 이름이 다섯글자 초과인 경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.parsingCars("longName,ta")
        }.isInstanceOf(WinnerCarRacingException::class.java)
    }
    @Test
    fun `글자 마지막에 ","가 있는 경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.parsingCars("longName,ta")
        }.isInstanceOf(WinnerCarRacingException::class.java)
    }

    @Test
    fun `시도 횟수가 없거나 null 인 경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.checkCountValidation(null)
        }.isInstanceOf(NullPointerException::class.java)
        assertThatThrownBy {
            WinnerCarRacingView.checkCountValidation("")
        }.isInstanceOf(NullPointerException::class.java)
    }

    @Test
    fun `시도 횟수가 1보다 작을 경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.checkCountValidation("-1")
        }.isInstanceOf(ArithmeticException::class.java)
    }

    @Test
    fun `시도 횟수가 숫자가 아닌경우`() {
        assertThatThrownBy {
            WinnerCarRacingView.checkCountValidation("ㄱ")
        }.isInstanceOf(NumberFormatException::class.java)
    }
}
