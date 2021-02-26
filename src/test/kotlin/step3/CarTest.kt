package step3

import org.junit.jupiter.api.Test

class CarTest {
    @Test
    internal fun `자동차 객체를 생성한다`() {
        assertThat(Car(0)).isEqualTo(Car(0))
    }
}
