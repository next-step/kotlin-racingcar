package camp.nextstep.edu.step.racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("대회 결과는")
class TournamentFinishStatusTest : BehaviorSpec ({

    Given("대회 결과가 성공적일때") {

        When("대회 상태 내부에서") {
            val tournamentFinishStatus = TournamentFinishStatus.activeTrue()

            Then("true 값을 반환한다") {
                tournamentFinishStatus.getTournamentStatus() shouldBe true
            }
        }
    }

})
