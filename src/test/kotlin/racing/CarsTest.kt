package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.domain.Cars
import racing.domain.Pedal

class CarsTest {
    @Test
    fun `차량 갯수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Cars.make(0, Pedal(0)) }
            .withMessage("양수만 가능합니다.")
    }
}
