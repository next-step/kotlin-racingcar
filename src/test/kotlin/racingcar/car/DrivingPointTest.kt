package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class DrivingPointBy {
    @Test
    fun `4 미만일 경우 0 을 반환한다`() {
        for (i in -100..3) Assertions.assertThat(drivingPointBy(i)).isEqualTo(0)
    }

    @Test
    fun `4 이상일 경우 1 을 반환한다`() {
        for (i in 4..100) Assertions.assertThat(drivingPointBy(i)).isEqualTo(1)
    }
}
