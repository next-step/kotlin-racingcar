package camp.nextstep.edu.step.racing.facade

import camp.nextstep.edu.step.racing.domain.TournamentFinishStatus
import camp.nextstep.edu.step.racing.dto.CreateTonamentDto
import camp.nextstep.edu.step.racing.service.CarService
import camp.nextstep.edu.step.racing.service.RacingTrackService
import camp.nextstep.edu.step.racing.service.TournamentService
import camp.nextstep.edu.step.racing.strategy.RandomMoveStrategy
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("Racing Facade는")
class RacingFacadeTest : BehaviorSpec ({
    val carService = CarService(RandomMoveStrategy())
    val racingTrackService = RacingTrackService
    val tournamentService = TournamentService(
        carService = carService,
        racingTrackService = racingTrackService
    )

    val racingFacade = RacingFacade(
        carService = carService,
        tournamentService = tournamentService
    )

    Given("자동차 이름들,트랙,대회이름, 시도횟수의 정보가 주어지고") {
        val carNames = "현대자동차,기아자동차,삼성자동차"
        val racingTrackName = "서울 올림픽 경기장"
        val tournamentName = "넥스트스텝 자동차 경주대회"
        val tryCount = 5

        val tonamentRequest = CreateTonamentDto(
            carName = carNames,
            racingTrackName = racingTrackName,
            tournamentName = tournamentName,
            tryCount = tryCount
        )

        When("경기가 시작된후 성공적으로 마무리가 되면") {
            val tournamentStatus = racingFacade.playRacingGame(createTonamentDto = tonamentRequest)

            Then("true 값을 반환한다") {
                tournamentStatus shouldBe TournamentFinishStatus.activeTrue()
            }
        }
    }
})
