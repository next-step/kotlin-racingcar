package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.vo.Position

@DisplayName("간단한 자동차(SimpleRacingCar)")
class SimpleRacingCarTest {
    @Test
    fun `자동차는 이동전략의 숫자가 4 이상인 경우에 이동한다`() {
        val movingCar = SimpleRacingFixture.MOVING_CAR
        val staticCar = SimpleRacingFixture.STATIC_CAR
        assertAll(
            { assertThat(movingCar.position).isEqualTo(Position(1)) },
            { assertThat(staticCar.position).isEqualTo(Position(1)) },
            { assertThat(movingCar.moved().position).isEqualTo(Position(2)) },
            { assertThat(staticCar.moved().position).isEqualTo(Position(1)) },
        )
    }
}
