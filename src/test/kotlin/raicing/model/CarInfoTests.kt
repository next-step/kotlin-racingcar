package raicing.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import raicing.Const

class CarInfoTests {

    @Nested
    @DisplayName("입력받은 문자열을 자동차 이름으로 변환 테스트")
    inner class SplitCarNamesTests {
        @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
        @ValueSource(strings = ["", " ", "\t"])
        fun `입력값이 비어있으면 실패 - IllegalArgumentException 발생`(carNameStr: String) {
            Assertions.assertThatIllegalArgumentException()
                .isThrownBy { CarInfo(carNameStr) }
                .withMessage(Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG)
        }

        @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
        @ValueSource(strings = ["abcdefgh", "한글테스트1"])
        fun `입력값이 5자를 초과하면 실패 - IllegalArgumentException 발생`(carNameStr: String) {
            Assertions.assertThatIllegalArgumentException()
                .isThrownBy { CarInfo(carNameStr) }
                .withMessage(Const.ErrorMsg.CAR_NAME_IS_TOO_LONG)
        }

        @ParameterizedTest(name = "입력값이 `{0}` 이면 성공")
        @ValueSource(strings = ["abc", "a", "한글"])
        fun `입력값에 5자 이하인 이름만 있으면 성공`(carNameStr: String) {
            val result = CarInfo(carNameStr)
            assertThat(result.name).isEqualTo(carNameStr)
        }
    }
}
