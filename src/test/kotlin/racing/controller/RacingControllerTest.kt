package racing.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.infra.RandomCarMovingStepper
import racing.service.CarService

internal class RacingControllerTest {

    @Test
    fun `잘못된 값을 입력하면 오류를 리턴한다`() {
        val car = 0
        val round = 3

        val racingController = RacingController(CarService(RandomCarMovingStepper()))

        assertThrows<IllegalArgumentException> {
            racingController.playGame(car, round)
        }
    }
}
