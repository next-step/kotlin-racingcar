package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given(name = "자동차 객체가 전진을 수행할 때") {
        `when`(name = "전진 조건이 true를 반환하면") {
            val actual = Car().apply { move { true } }

            then(name = "위치 정보는 증가한다.") {
                actual shouldBe Car(Distance(1L))
            }
        }

        `when`(name = "전진 조건이 false를 반환하면") {
            val actual = Car().apply { move { true } }

            then(name = "위치 정보는 그대로 유지된다.") {
                actual shouldBe Car(Distance.ZERO)
            }
        }
    }
})
