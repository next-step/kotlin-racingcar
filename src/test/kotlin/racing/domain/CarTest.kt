package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given(name = "자동차 객체가 전진을 수행할 때") {
        `when`(name = "전진 조건이 true를 반환하면") {
            val actual = Car().apply { move { true } }

            then(name = "위치 정보는 증가한다.") {
                actual shouldBe Car(distance = Distance(1L))
            }
        }

        `when`(name = "전진 조건이 false를 반환하면") {
            val actual = Car().apply { move { false } }

            then(name = "위치 정보는 그대로 유지된다.") {
                actual shouldBe Car(distance = Distance.ZERO)
            }
        }
    }

    given("자동차 객체가 위치 값을 비교할 때") {
        val source = Car(distance = Distance(10L))

        `when`("더 멀리 이동한 자동차와 비교할 경우") {
            val target = Car(distance = Distance(20L))

            val actual: Int = source.compareTo(target)

            then("음수를 반환한다") {
                actual shouldBeLessThan 0
            }
        }

        `when`("더 적게 이동한 자동차와 비교할 경우") {
            val target = Car(distance = Distance(5L))

            val actual: Int = source.compareTo(target)

            then("양수를 반환한다") {
                actual shouldBeGreaterThan 0
            }
        }

        `when`("동일하게 이동한 자동차와 비교할 경우") {
            val target = Car(distance = Distance(10L))

            val actual: Int = source.compareTo(target)

            then("0dmf 반환한다") {
                actual shouldBe 0
            }
        }
    }
})
