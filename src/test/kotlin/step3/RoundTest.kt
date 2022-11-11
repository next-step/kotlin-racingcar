package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class RoundTest : FunSpec({
    context("라운드 시작 테스트") {
        context("라운드 시작이 완료되면") {
            test("라운드 결과를 반환한다.") {
                // given
                val sut = Round(id = 1)
                val cars = CarFactory.createMany(amount = 3)
                // when
                val actual = sut.start(cars = cars)
                // then
                actual.carPositions shouldHaveSize 3
            }
        }
    }
})
