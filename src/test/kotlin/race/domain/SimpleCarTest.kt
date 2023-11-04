package race.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import race.domain.SimpleCar.Companion.NAME_MAX_LENGTH
import java.lang.IllegalArgumentException

class SimpleCarTest {
    @ParameterizedTest
    @ValueSource(strings = ["orange", "pineapple"])
    fun `name 최대길이 정책위반시 exception throw`(name: String) {
        Assertions.assertThatThrownBy { SimpleCar(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 ${NAME_MAX_LENGTH}자를 초과할 수 없습니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["apple", "melon", "kiwi"])
    fun `name 최대길이 정책 준수`(name: String) {
        Assertions.assertThatNoException().isThrownBy { SimpleCar(name) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `임계값 이상이 전달 되었을 때만 자동차 이동`(value: Int) {
        val car = SimpleCar("test")

        car.move(value)
        assertThat(car.location == 1).isEqualTo(value >= SimpleCar.MOVE_THRESHOLD)
    }
}
