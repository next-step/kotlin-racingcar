package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5])
    fun `값이 4 이상일 경우 position을 1 증가시킨다`(condition: Int) {
        val car = Car(name = "김설영")

        car.moveOrStay(condition)

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3])
    fun `값이 4 미만일 경우 position은 그대로 유지된다`(condition: Int) {
        val car = Car(name = "김설영")

        car.moveOrStay(condition)

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest(name = "value = \"{0}\"")
    @ValueSource(strings = ["", "     "])
    fun `자동차 이름은 비어있을 수 없다`(name: String) {
        assertThatThrownBy { Car(name = name) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름은 5글자를 초과할 수 없다`() {
        assertThatThrownBy { Car(name = "이건딱6글자") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
