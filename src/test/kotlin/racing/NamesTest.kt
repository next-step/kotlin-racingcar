package racing

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racing.model.Names
import racing.model.Names.Companion.INVALID_CAR_NAMES

class NamesTest {
    @Test
    fun `자동차 이름 입력 개수 에러 테스트`() {
        assertThatIllegalArgumentException().isThrownBy {
            Names(listOf())
        }.withMessage(INVALID_CAR_NAMES)
    }
}
