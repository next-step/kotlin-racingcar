package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `라운드 갯수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Round.make(0) }
            .withMessage("양수만 가능합니다.")
    }
}
