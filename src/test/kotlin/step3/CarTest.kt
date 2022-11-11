package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("자동차 주행 테스트") {
        context("연료가 충분하면") {
            test("자동차는 움직일 수 있다.") {
                // given
                val sut = Car()
                val 충분한_연료 = 4
                // when
                sut.move(fuel = 충분한_연료)
                //
                sut.position shouldBe 1
            }
        }

        context("연료가 부족하면") {
            test("자동차는 움직일 수 없다.") {
                // given
                val sut = Car()
                val 부족한_연료 = 3
                // when
                sut.move(fuel = 부족한_연료)
                // then
                sut.position shouldBe 0
            }
        }
    }
})
