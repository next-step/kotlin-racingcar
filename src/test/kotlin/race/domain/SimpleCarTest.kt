package race.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import race.domain.SimpleCar.Companion.NAME_MAX_LENGTH
import java.lang.IllegalArgumentException

class SimpleCarTest {
    @ParameterizedTest
    @ValueSource(strings = ["orange"])
    fun `name 최대길이 정책위반시 exception throw`(name: String) {
        Assertions.assertThatThrownBy { SimpleCar(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 ${NAME_MAX_LENGTH}자를 초과할 수 없습니다")
    }

    @Test
    fun `지정된 수치 이상이 전달 되었을 때만 자동차 이동`() {
        val car = SimpleCar("test")

        (0..3).forEach {
            car.move(it)
            assertThat(car.getLocation()).isEqualTo(0)
        }

        car.move(SimpleCar.MOVE_THRESHOLD)
        assertThat(car.getLocation()).isEqualTo(1)
    }
}
