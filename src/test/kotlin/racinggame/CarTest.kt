package racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class CarTest : DescribeSpec({

    describe("move") {
        context("값이 4 이상 9 이하이면") {
            it("전진한다") {
                listOf(4, 5, 6, 7, 8, 9).forAll {
                    val car = Car(0)
                    car.move(it)
                    car.position shouldBe 1
                }
            }
        }

        context("값이 0 이상 4 미만이면") {
            it("멈춰있는다") {
                listOf(0, 1, 2, 3).forAll {
                    val car = Car(0)
                    car.move(it)
                    car.position shouldBe 0
                }
            }
        }

        context("값이 0 미만 10 초과이면") {
            it("IllegalArgumentException 예외가 발생한다") {
                listOf(-1, 10, -100, 100).forAll {
                    val car = Car(0)
                    val exception = shouldThrow<IllegalArgumentException> {
                        car.move(it)
                    }
                    exception.message shouldContain "전진 조건 수는 0에서 9 사이 정수이어야합니다"
                }
            }
        }
    }
})
