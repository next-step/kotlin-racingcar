package racingcar.tasks

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import racingcar.model.Car
import racingcar.util.Message.Companion.ONE_DISTANCE

@Suppress("NonAsciiCharacters")
class CarTest {

    @Test
    fun `자동차 1번 전진`() {
        val car = Car().apply {
            tryMove(true)
        }

        Assertions.assertThat(car.whereIs())
            .isEqualTo(ONE_DISTANCE)
    }
}
