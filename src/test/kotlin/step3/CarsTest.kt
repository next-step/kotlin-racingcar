package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `자동차 일급컬랙션을 생성할 수 있다`() {
        assertThat(Cars(3)).isEqualTo(Cars(3))
    }
}
