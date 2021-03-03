package racingcar

import fixture.CarFixture.KIM_CAR
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차를 전진시키면 위치가 한칸 증가한다`() {
        val car = KIM_CAR

        car.forward()

        assertThat(car.position).isEqualTo(Position(1))
    }

    @Test
    fun `자동차 생성 시 이름이 5글자이상인 경우 예외처리한다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car("Alistart")
        }.withMessageMatching("이름은 5글자를 초과할 수 없습니다.")
    }
}
