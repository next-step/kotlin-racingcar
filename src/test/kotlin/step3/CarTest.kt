package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차를 움직이면 위치가 1씩 증가한다`() {
        //given
        val car = Car(ManualCarMover())
        val position = car.position

        //when
        car.move()

        //then
        assertThat(car.position).isEqualTo(position + 1)
    }
}