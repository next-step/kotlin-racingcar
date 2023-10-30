package racing

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec

class CarRacingStarterTest : BehaviorSpec({
    given("자동차 이름이") {
        val carNames = listOf("abcdefg")
        `when`("5자를 초과한 경우") {
            then("IllegalArgumentException throw") {
                shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 5자를 초과할 수 없습니다.") {
                    CarRacingStarter().ready(carNames)
                }
            }
        }
    }
})
