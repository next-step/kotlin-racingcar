package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CarTest : FunSpec({
    context("자동차 주행 테스트") {
        context("연료가 충분하면") {
            test("자동차는 움직일 수 있다.") {
                // given
                val sut = Car(id = 1, name = CarName(value = "동구"))
                val 충분한_연료 = Oil(amount = 4)
                // when
                sut.move(movePolicy = OilPolicy(oil = 충분한_연료))
                //
                sut.position shouldBe Position(value = 1)
            }
        }

        context("연료가 부족하면") {
            test("자동차는 움직일 수 없다.") {
                // given
                val sut = Car(id = 1, name = CarName(value = "동구"))
                val 부족한_연료 = Oil(amount = 3)
                // when
                sut.move(movePolicy = OilPolicy(oil = 부족한_연료))
                // then
                sut.position shouldBe Position(value = 0)
            }
        }

        context("주행하고 나면") {
            test("주행한 위치를 가지는 새로운 자동차를 반환할 수 있다.") {
                // given
                val car = Car(id = 1, name = CarName(value = "동구"))
                val 충분한_연료 = Oil(amount = 6)
                // when
                val actual = car.move(movePolicy = OilPolicy(oil = 충분한_연료))
                // then
                actual shouldNotBe car
                with(actual) {
                    this.id shouldBe car.id
                    this.name shouldBe car.name
                    this.position shouldBe Position(value = 1)
                }
            }
        }
    }

    context("자동차 생성 테스트") {
        test("기존의 자동차를 통해 새로운 자동차를 생성할 수 있다.") {
            // given
            val car = Car(id = 1, name = CarName(value = "동구"), position = Position(value = 3))
            // when
            val actual = Car(car = car)
            // then
            actual shouldNotBe car
            with(actual) {
                this.id shouldBe car.id
                this.name shouldBe car.name
                this.position shouldBe car.position
            }
        }
    }
})
