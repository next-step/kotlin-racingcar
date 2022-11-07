package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `기본 인자로 생성한 자동차는 0의 진행도를 가진다`() {
        assertThat(Car()).isEqualTo(Car(0))
    }

    @Test
    fun `go()를 하면 자동차가 한 칸 전진한다`() {
        val car = Car()
        car.go()
        assertThat(car).isEqualTo(Car(1))
    }

    @Test
    fun `now는 현재의 진행도를 반환한다`() {
        val car = Car(0)

        car.go()
        assertThat(car.now()).isEqualTo(1)
    }
}
