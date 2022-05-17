package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class DrivingForceTest {
    @Test
    fun `주어진 Int 값이 0~3 이면 0 을 반환한다`() {
        for (i in 0..3) Assertions.assertThat(DrivingForce.pointBy(i)).isEqualTo(0)
    }

    @Test
    fun `주어진 Int 값이 4~9 이면 1 을 반환한다`() {
        for (i in 4..9) Assertions.assertThat(DrivingForce.pointBy(i)).isEqualTo(1)
    }

    @Test
    fun `주어진 Int 값이 0 미만이면 에러가 발생한다`() {
        for (i in -10000..-1) Assertions.assertThatThrownBy { DrivingForce.pointBy(i) }
    }

    @Test
    fun `주어진 Int 값이 9를 초과하면 에러가 발생한다`() {
        for (i in 10..10000) Assertions.assertThatThrownBy { DrivingForce.pointBy(i) }
    }
}
