package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.MoveStrategy
import racingcar.repository.CarRepository
import racingcar.service.RangeRandomGenerator
import racingcar.view.response.GameResult

private class RacingCarServiceTest {
    val racingCarService = RacingCarService(
        CarRepository(),
        RangeRandomGenerator(),
        TestMoveStrategy()
    )

    @Test
    fun `자동차가 2대 미만인 경우 예외`() {
        assertThrows<IllegalArgumentException> { racingCarService.playGame(1, 2) }
            .also { assertThat(it.message).isEqualTo("자동차 대수는 2대 이상이어야 합니다.") }
    }

    @Test
    fun `시도가 1회 미만인 경우 예외`() {
        assertThrows<IllegalArgumentException> { racingCarService.playGame(2, 0) }
            .also { assertThat(it.message).isEqualTo("시도 횟수는 1번 이상이어야 합니다") }
    }

    @Test
    fun `정상 동작`() {
        val gameResult = racingCarService.playGame(3, 4)
        assertThat(gameResult.repsResults).hasSize(4)
        assertThat(gameResult.repsResults.get(0).snapShots)
            .flatExtracting(GameResult.CarSnapShot::position)
            .isEqualTo(listOf(1, 1, 1))
        assertThat(gameResult.repsResults.get(1).snapShots)
            .flatExtracting(GameResult.CarSnapShot::position)
            .isEqualTo(listOf(2, 2, 2))
        assertThat(gameResult.repsResults.get(2).snapShots)
            .flatExtracting(GameResult.CarSnapShot::position)
            .isEqualTo(listOf(3, 3, 3))
        assertThat(gameResult.repsResults.get(3).snapShots)
            .flatExtracting(GameResult.CarSnapShot::position)
            .isEqualTo(listOf(4, 4, 4))
    }
}

class TestMoveStrategy : MoveStrategy {
    override fun move(car: Car) {
        car.move()
    }
}
