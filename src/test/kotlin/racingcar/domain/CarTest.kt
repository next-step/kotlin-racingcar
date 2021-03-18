package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class CarTest {

    @Test
    @DisplayName("랜덤으로 선정된 값이 기준 확률보다 커 자동차가 움직일 수 있다")
    fun tryMoveSuccess() {
        val car = Car("mj")
        car.tryMove(10)
        assertThat(car.position).isEqualTo(1)
        assertThat(car.userName).isEqualTo("mj")
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    fun name() {
        assertThrows<IllegalArgumentException> {
            val car = Car("jyami")
        }
    }
}
