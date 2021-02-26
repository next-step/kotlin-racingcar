package step3

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차 객체를 생성한다`() {
        assertThat(Car()).isEqualTo(Car())
    }

    @Test
    fun `자동차 객체는 움직인다`() {
        assertThat(Car(moveable = Moveable.Always()).driving()).isEqualTo(Position(1))
    }

    @Test
    fun `Position 은 음수를 가질 수 없다`() {
        assertThrows<IllegalArgumentException> { Position(-1) }
    }
}
