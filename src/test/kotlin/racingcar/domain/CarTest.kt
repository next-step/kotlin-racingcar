package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.utils.RandomGenerator

class CarTest : BehaviorSpec({
    given("Car 객체") {
        val car = Car()
        `when`("움직일 수 있는 값과 함께 move() 호출") {
            val result = car.move(RandomGenerator(4, 9).generate())
            then("1칸 전진") {
                result shouldBe 1
            }
        }
        `when`("움직인 상태에서 움직일 수 있는 값과 함께 move() 호출") {
            val result = car.move(RandomGenerator(0, 3).generate())
            then("이전 값을 유지") {
                result shouldBe 1
            }
        }
    }
})
