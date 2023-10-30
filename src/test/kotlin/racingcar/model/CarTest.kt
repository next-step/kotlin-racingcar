package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CarTest {

    @Test
    fun `1칸 전진 시 position 이 1 증가한다`() {
        val car = Car(name = "myCar")
        car.stepForward(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car 생성 시 이름이 5자 이상이면 실패한다`() {
        assertThrows<IllegalArgumentException> { Car("NameName") }
    }
}
