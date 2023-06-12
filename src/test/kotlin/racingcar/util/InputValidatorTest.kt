package racingcar.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.util.InputValidator

class InputValidatorTest {

    @Test
    fun `검증 테스트`() {
        val carNameInput = "a,b,c"
        val turnCountInput = "5"

        try {
            InputValidator.carNameInputValidate(carNameInput)
            InputValidator.carNameInputValidate(turnCountInput)
        } catch (e: IllegalArgumentException) {
            Assertions.fail<AssertionError>("정상 입력 값일 때는 검증에 실패하면 안됨")
        }
    }

    @Test
    fun `자동차 이름이 5글자 이상일 때 에러 발생 테스트`() {
        val carNameInput = "abcde,fghijk"

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            InputValidator.carNameInputValidate(carNameInput)
        }
    }

    @Test
    fun `시도할 횟수가 문자열일 때 에러 발생 테스트`() {
        val turnCountInput = "abc"

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            InputValidator.turnCountValidate(turnCountInput)
        }
    }

    @Test
    fun `시도할 횟수가 실수일 때 에러 발생 테스트`() {
        val turnCountInput = "2.0"

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            InputValidator.turnCountValidate(turnCountInput)
        }
    }
}
