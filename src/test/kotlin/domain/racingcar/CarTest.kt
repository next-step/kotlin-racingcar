package domain.racingcar

import fixture.CarFixture.KIM_CAR
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @Test
    fun `자동차를 전진시키면 위치가 한칸 증가한다`() {
        val car = KIM_CAR

        car.forward()

        assertThat(car.position).isEqualTo(Position(1))
    }

    @ParameterizedTest
    @ValueSource(strings= ["Alistart", "fiive"])
    fun `자동차 생성 시 이름이 5글자초과인 경우 예외처리한다`(name: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car(name)
        }.withMessageMatching("이름은 5글자를 초과할 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings= ["four", "two", "o"])
    fun `자동차 생성 시 이름이 5글자이하인 경우 예외가 발생하지 않는다`(name: String) {
        val car = Car(name)

        assertThat(car).isNotNull
    }
}
