package step3.model

import io.kotest.core.spec.style.BehaviorSpec

class DefaultCarTest : BehaviorSpec({
    given("차") {
        then("차 객체 생성시 track은 비어있다") {
        }
        `when`("차가 전진한다") {
            then("track이 한칸 이동한다") {
            }
        }
    }
})
