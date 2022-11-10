package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `기본 인자로 생성한 자동차는 ""의 이름과 0의 진행도를 가진다`() {
        assertThat(Car()).isEqualTo(Car(name = "", _progress = 0))
    }

    @Test
    fun `자동차에 이름을 붙여줄 수 있다`() {
        val name = "나의 첫 자동차"
        assertThat(Car(name)).isEqualTo(Car(name = "나의 첫 자동차"))
    }

    @Test
    fun `progress 를 통해 현재의 진행도를 알 수 있다`() {
        val car = Car(_progress = 0)

        car.move()
        assertThat(car.progress).isEqualTo(1)
    }
}
