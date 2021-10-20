package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `차량 갯수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Game(carCount = 0, roundCount = 1, canMoveForward = canMoveForward, movingCondition = 1) }
            .withMessage("양수만 가능합니다.")
    }

    @Test
    fun `라운드 횟수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Game(carCount = 1, roundCount = 0, canMoveForward = canMoveForward, movingCondition = 1) }
            .withMessage("양수만 가능합니다.")
    }
}
