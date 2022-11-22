package study.racing

import org.junit.jupiter.api.Test
import study.racing.domain.entity.Race
import study.racing.domain.entity.RacingCar
import study.racing.domain.repository.RacingCarRepositoryImpl

class RaceTest {

    @Test
    fun `경주를 시작하면 회차 별로 자동차의 위치가 기록이 된다`() {
        val roundCount = 5
        val repo = RacingCarRepositoryImpl(RandomPowerSource())
        val race = Race(
            roundCount = roundCount,
            cars = listOf("Car1", "Car2")
                .map { name ->
                    RacingCar(name, repo)
                }
        )
        race.start()

        val recordCount = race.rounds
            .mapNotNull { it.record }
            .size

        assert(recordCount == roundCount)
    }
}