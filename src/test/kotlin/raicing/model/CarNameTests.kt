package raicing.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import raicing.Const

class CarNameTests {

    @Nested
    @DisplayName("입력받은 문자열을 자동차 이름으로 변환 테스트")
    inner class SplitCarNamesTests {

        @ParameterizedTest(name = "CarInfo의 이름은 `{0}` 이다.")
        @ValueSource(strings = ["abc", "a", "한글"])
        fun `CarInfo는 문자열이 5자 이하인 이름을 가진다`(carNameStr: String) {
            val actual = CarName(carNameStr)
            assertThat(actual.toString()).isEqualTo(carNameStr)
        }

        @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
        @ValueSource(strings = ["", " ", "\t"])
        fun `입력값이 비어있으면 실패 - IllegalArgumentException 발생`(carNameStr: String) {
            Assertions.assertThatIllegalArgumentException()
                .isThrownBy { CarName(carNameStr) }
                .withMessage(Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG)
        }

        @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
        @ValueSource(strings = ["abcdefgh", "한글테스트1"])
        fun `입력값이 5자를 초과하면 실패 - IllegalArgumentException 발생`(carNameStr: String) {
            Assertions.assertThatIllegalArgumentException()
                .isThrownBy { CarName(carNameStr) }
                .withMessage(Const.ErrorMsg.CAR_NAME_IS_TOO_LONG)
        }
    }
}
