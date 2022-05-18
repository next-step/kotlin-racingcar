package racingCar.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `random 숫자로 0이 나오면 움직이지 않는다`() {
        // given
        val car = Car()

        // when
        car.move(0)

        // then
        Assertions.assertThat(car.moves).isEqualTo(0)
    }

    @Test
    fun `random 숫자로 4가 나오면 자동차를 앞으로 한 칸 이동시킨다`() {
        //given
        val car = Car()
        val initialMove = car.moves

        //when
        car.move(4)
        val forwardOnce = car.moves

        //then
        Assertions.assertThat(initialMove + 1).isEqualTo(forwardOnce)
    }

    @Test
    fun `random 숫자로 5가 나오면 자동차를 앞으로 한 칸 이동시킨다`() {
        //given
        val car = Car()
        val initialMove = car.moves

        //when
        car.move(5)
        val forwardOnce = car.moves

        //then
        Assertions.assertThat(initialMove + 1).isEqualTo(forwardOnce)
    }
}