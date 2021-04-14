package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.movestrategy.FakeMoveStrategy
import racingcar.domain.movestrategy.FakeNotMoveStrategy

internal class CarTest {

    private val distance = Distance(1)
    private val car = Car(Name("test"), distance)

    @Test
    fun `같은 거리인지 체크 같은 거리일 경우`() {
        assertThat(car.isSameDistance(distance)).isTrue()
    }

    @Test
    fun `같은 거리인지 체크 다른 거리일 경우`() {
        assertThat(car.isSameDistance(Distance(2))).isFalse()
    }

    @Test
    fun `이동이 가능한 경우 거리가 바뀐다`() {
        val movedCar = car.move(FakeMoveStrategy())

        assertThat(movedCar.distance).isEqualTo(Distance(2))
    }

    @Test
    fun `이동이 불가능한 경우 거리가 바뀌지 않는다`() {
        val movedCar = car.move(FakeNotMoveStrategy())
        assertThat(movedCar.distance).isEqualTo(distance)
    }
}
