package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차 객체가 올바르게 생성되는지 확인한다`() {
        assertThat(Car("pobi")).isNotNull
    }

    @Test
    fun `자동차가 앞으로 전진하는지 확인한다`() {
        val car = Car("Car")
        car.forward(8)
        assertThat(car.distance).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["car1", "car2", "car3"])
    fun `올바른 자동차 이름 입력 테스트 길이 5이하`(name: String) {
        assertThat(Car(name).carName).isEqualTo(name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["car1234", "car212312", "car314124"])
    fun `자동차 이름 입력 제한 초과 테스트 Exception 발생`(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }
}
