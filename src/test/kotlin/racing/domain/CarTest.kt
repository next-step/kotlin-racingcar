package racing.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({
    describe(name = "자동차 객체가 전진을 수행할 때") {
        context(name = "전진 조건이 true를 반환하면") {
            val actualCar = Car()

            actualCar.move { true }

            it(name = "위치 정보는 증가한다.") {
                actualCar shouldBe Car(Distance(1L))
            }
        }

        context(name = "전진 조건이 false를 반환하면") {
            val actualCar = Car()
            actualCar.move { false }

            it(name = "위치 정보는 그대로 유지된다.") {
                actualCar shouldBe Car(Distance.ZERO)
            }
        }
    }
})
