package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class CarFactoryTest : FunSpec({
    val sut = CarFactory
    context("자동차 생성 테스트") {
        context("수량이 주어지면") {
            test("수량만큼 자동차를 생성한다.") {
                // given
                val 수량 = 5
                // when
                val actual = sut.createMany(amount = 수량)
                // then
                actual shouldHaveSize 수량
            }
        }
    }
})
