package study.racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.RacingCar

class RacingCarTest {
    @Test
    fun `자동차 게임을 한다`() {
        // given
        val carNumber = 1
        val tryNumber = 3

        // when
        val cars = RacingCar(carNumber, tryNumber, AlwaysMove()).start()

        // then
        cars[0].moveHistory.movements shouldBe listOf(1, 2, 3)
    }
}
