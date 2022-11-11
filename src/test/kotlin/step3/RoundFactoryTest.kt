package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class RoundFactoryTest : FunSpec({
    val sut = RoundFactory
    context("라운드 생성 테스트") {
        context("수량이 주어지면") {
            test("수량만큼 라운드를 생성한다.") {
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
