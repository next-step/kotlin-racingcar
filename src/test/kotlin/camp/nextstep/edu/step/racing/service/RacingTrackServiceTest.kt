package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.RacingTrack
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("레이싱 경기장 서비스는")
class RacingTrackServiceTest : BehaviorSpec({
    val racingTrackService = RacingTrackService

    Given("경기장 이름을 정하고") {
        val trackName = "넥스트스텝 경기장"

        When("경기장을 생성하면") {
            val racingTrack = racingTrackService.createRacingTrack(trackName)

            Then("요청한 이름의 경기장이 생성된다") {
                racingTrack shouldBe RacingTrack.of(trackName = "넥스트스텝 경기장")
                racingTrack.trackName shouldBe "넥스트스텝 경기장"
            }
        }
    }

})
