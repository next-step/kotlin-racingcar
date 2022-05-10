package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `외부에서 들어온 전진 가능한 로직대로 전진하는지 테스트`(input: Boolean) {
        val testGoDecide = {
            input
        }

        val car = Car("name", testGoDecide)
        car.proceed()
        val afterPosition = car.position
        val expectPosition = if (input) 1 else 0

        assertThat(afterPosition).isEqualTo(expectPosition)
    }
}
