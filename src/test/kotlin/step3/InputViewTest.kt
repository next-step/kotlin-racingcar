package step3

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class InputViewTest {

    @Test
    fun `자동차 수가 null이거나 비어있는 경우 validate시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputView().validate("", "3")
        }.withMessage(InputView.DATA_IS_BLANK)
    }

    @Test
    fun `문자가 입력된 경우 validate시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputView().validate("1", "A")
        }.withMessage(InputView.IS_POSSIBLE_NUMERIC)
    }

    @Test
    fun `자동차 수가 1보다 작을 경우 validate 시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputView().validate("-1", "1")
        }.withMessage(InputView.NUMBER_REQUIRE_OVER_ONE)
    }
}
