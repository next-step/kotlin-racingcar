package camp.nextstep.edu.step.racing.dto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class CreateTonamentDtoTest : BehaviorSpec ({

    Given("대회와 관련된 입력값이 주어지고") {
        val carName = "현대자동차"
        val racingTrackName = "경기도 하남 레이싱트랙"
        val tournamentName = "캠프 페스티벌"
        val tryCount = 5

        When("대회 생성 DTO를 생성하면") {
            val createTournamentDto = CreateTonamentDto(
                carName = carName,
                racingTrackName = racingTrackName,
                tournamentName = tournamentName,
                tryCount = tryCount
            )

            Then("주어진 정보의 대회 생성 DTO가 생성된다") {
                createTournamentDto.carName shouldBe "현대자동차"
                createTournamentDto.racingTrackName shouldBe "경기도 하남 레이싱트랙"
                createTournamentDto.tournamentName shouldBe "캠프 페스티벌"
                createTournamentDto.tryCount shouldBe 5
            }
        }
    }
})
