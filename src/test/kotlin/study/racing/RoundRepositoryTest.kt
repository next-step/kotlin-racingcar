package study.racing

import org.junit.jupiter.api.Test
import study.racing.domain.entity.RacingCar
import study.racing.domain.entity.Round
import study.racing.domain.repository.RoundRepositoryImpl

class RoundRepositoryTest {

    @Test
    fun `자동차의 위치가 제일 높은 경우 해당 회차의 우승자가 된다`() {
        val car1Repo = FakeRacingCarRepository(0, true)
        val car2Repo = FakeRacingCarRepository(0, true)
        val car3Repo = FakeRacingCarRepository(0, false)
        val roundRepo = RoundRepositoryImpl()

        val (car1, car2, car3) = listOf(
            "Car1" to car1Repo,
            "Car2" to car2Repo,
            "Car3" to car3Repo
        ).map { (name, repo) -> RacingCar(name, repo) }

        val round = Round(
            roundRepo,
            listOf(car1, car2, car3)
        )

        round.race()
        val winner = roundRepo.getWinner(round)

        assert(winner.size == 2)
        assert(winner.map { it.name } == listOf(car1.name, car2.name))
    }
}