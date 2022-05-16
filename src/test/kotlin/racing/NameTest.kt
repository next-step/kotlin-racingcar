package racing

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.model.Name
import racing.model.Name.Companion.INVALID_CAR_NAME_BLANK
import racing.model.Name.Companion.INVALID_CAR_NAME_LENGTH

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = ["12345678", "123456"])
    fun `자동차 이름 5자 초과 에러 테스트`(name: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Name(name)
        }.withMessage(INVALID_CAR_NAME_LENGTH)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "    "])
    fun `자동차 이름 공백 에러 테스트`(name: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Name(name)
        }.withMessage(INVALID_CAR_NAME_BLANK)
    }
}
