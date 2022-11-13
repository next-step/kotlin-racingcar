package racingcar.model

import io.kotest.core.spec.style.BehaviorSpec

class CompeteCarTest : BehaviorSpec({
    given("CompeteCar") {
        `when`("Kim Car가 전진하면") {
            then("Kim Car의 track이 한칸 이동한다") {}
        }
    }
})
