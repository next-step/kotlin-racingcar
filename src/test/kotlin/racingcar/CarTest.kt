package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `Threshold 이상일때만 전진 하는지 테스트`(input: Int) {
        val car = Car()

        val beforePosition = car.position

        car.valueGenerator = { input }
        car.proceed()

        val afterPosition = car.position

        val expect = if (input >= 4) beforePosition + 1 else beforePosition
        assertThat(afterPosition).isEqualTo(expect)
    }
}
