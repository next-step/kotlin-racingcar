package camp.nextstep.edu.step.racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("경주장은")
class RacingTrackTest : BehaviorSpec ({

        Given("경주장 이름이 주어지면") {
            val trackName = "경기도 하남 레이싱트랙"

            When("경주장을 생성하면") {
                val racingTrack = RacingTrack.of(trackName = trackName)

                Then("주어진 이름의 경주장이 생성된다") {
                    racingTrack shouldBe RacingTrack.of(trackName = "경기도 하남 레이싱트랙")
                    racingTrack.trackName shouldBe "경기도 하남 레이싱트랙"
                }
            }
        }

        Given("만약 경주장 이름이 없는데") {
            val trackName = ""

            When("경주장을 생성하면") {
                val racingTrack = shouldThrow<IllegalArgumentException> {
                    RacingTrack.of(trackName = trackName)
                }

                Then("예외가 발생한다") {
                    racingTrack.message shouldBe "경주장의 이름이 비어있습니다."
                }
            }
        }

})
