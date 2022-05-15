package racingCar.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `play에 0을 넣으면 움직이지 않는다`() {
        // given
        val car = Car()

        // when
        car.move()

        // then
        Assertions.assertThat(car.moves).isEqualTo(0)
    }

    @Test
    fun `goForward 함수에 4를 넣으면 자동차를 앞으로 한 칸 이동시킨다`() {
        //given
        val car = Car()
        val initialMove = car.moves

        //when
        car.goForward(4)
        val forwardOnce = car.moves

        //then
        Assertions.assertThat(initialMove + 1).isEqualTo(forwardOnce)
    }

    @Test
    fun `goForward 함수에 5를 넣으면 자동차를 앞으로 한 칸 이동시킨다`() {
        //given
        val car = Car()
        val initialMove = car.moves

        //when
        car.goForward(5)
        val forwardOnce = car.moves

        //then
        Assertions.assertThat(initialMove + 1).isEqualTo(forwardOnce)
    }
}