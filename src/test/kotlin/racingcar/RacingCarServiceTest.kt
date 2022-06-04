package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.MoveStrategy
import racingcar.service.RangeRandomGenerator
import racingcar.view.response.CarSnapShot
import racingcar.view.response.Winner

private class RacingCarServiceTest {
    val racingCarService = RacingCarService(
        RangeRandomGenerator(),
        TestMoveStrategy()
    )

    @Test
    fun `자동차가 2대 미만인 경우 예외`() {
        assertThrows<IllegalArgumentException> { racingCarService.playGame(listOf("pobi"), 2) }
            .also { assertThat(it.message).isEqualTo("자동차 대수는 2대 이상이어야 합니다.") }
    }

    @Test
    fun `시도가 1회 미만인 경우 예외`() {
        assertThrows<IllegalArgumentException> { racingCarService.playGame(listOf("pobi", "crong"), 0) }
            .also { assertThat(it.message).isEqualTo("시도 횟수는 1번 이상이어야 합니다") }
    }

    @Test
    fun `정상 동작`() {
        val gameResult = racingCarService.playGame(listOf("pobi", "crong", "honux"), 4)
        assertThat(gameResult.repsResults).hasSize(4)
        assertThat(gameResult.repsResults[0].snapShots)
            .flatExtracting(CarSnapShot::position)
            .isEqualTo(listOf(1, 1, 1))
        assertThat(gameResult.repsResults[1].snapShots)
            .flatExtracting(CarSnapShot::position)
            .isEqualTo(listOf(2, 2, 2))
        assertThat(gameResult.repsResults[2].snapShots)
            .flatExtracting(CarSnapShot::position)
            .isEqualTo(listOf(3, 3, 3))
        assertThat(gameResult.repsResults[3].snapShots)
            .flatExtracting(CarSnapShot::position)
            .isEqualTo(listOf(4, 4, 4))
        assertThat(gameResult.winners)
            .flatExtracting(Winner::name)
            .containsExactly("pobi", "crong", "honux")
    }
}

class TestMoveStrategy : MoveStrategy {
    override fun move(car: Car) {
        car.move()
    }
}
