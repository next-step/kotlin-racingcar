package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun `check car data class`() {
        val item = Car(name = "사람")

        Assertions.assertThat(item).isEqualTo(Car(name = "사람", movement = 0))
        Assertions.assertThat(item.name).isEqualTo("사람")
        Assertions.assertThat(item.movement).isEqualTo(0)
    }
}
