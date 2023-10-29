package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.TournamentFinishStatus
import camp.nextstep.edu.step.racing.strategy.RandomMoveStrategy
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("대회가 서비스는")
class TournamentServiceTest : BehaviorSpec({
    val tournamentService = TournamentService(
        carService = CarService(RandomMoveStrategy()),
        racingTrackService = RacingTrackService
    )

    Given("대회 정보를 요청하고") {
        val carNames = "현대자동차,기아자동차,삼성자동차"
        val racingTrackName = "서울 올림픽 경기장"
        val tournamentName = "넥스트스텝 자동차 경주대회"
        val tryCount = 5

        When("대회 생성을 요청하면") {
            val tournament = tournamentService.createTournament(
                carNames = carNames,
                racingTrackName = racingTrackName,
                tournamentName = tournamentName,
                tryCount = tryCount
            )

            Then("요청값과 같은 대회가 생성된다") {
                tournament.tournamentName shouldBe "넥스트스텝 자동차 경주대회"
                tournament.track.trackName shouldBe "서울 올림픽 경기장"
                tournament.getTryCount() shouldBe 5
                tournament.getCarListSize() shouldBe 3
                tournament.getCarListInTournament().map { it.carName } shouldBe listOf(
                    "현대자동차",
                    "기아자동차",
                    "삼성자동차"
                )
            }
        }
    }

    Given("대회를 생성하고") {
        val carNames = "현대자동차,기아자동차,삼성자동차"
        val racingTrackName = "서울 올림픽 경기장"
        val tournamentName = "넥스트스텝 자동차 경주대회"
        val tryCount = 5

        val tournament = tournamentService.createTournament(
            carNames = carNames,
            racingTrackName = racingTrackName,
            tournamentName = tournamentName,
            tryCount = tryCount
        )

        When("경기가 시작되고 성공적으로 마무리가 되면") {
            val tournamentStatus = tournamentService.startTournamentRace(tournament = tournament)

            Then("true 값을 반환한다") {
                tournamentStatus shouldBe TournamentFinishStatus.activeTrue()
            }
        }
    }

})
