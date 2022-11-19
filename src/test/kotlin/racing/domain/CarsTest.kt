package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({

    given("자동차들이") {
        `when`("전진 조건을 만족할때") {
            val cars = Cars(List(4) { Car() }, object : CarMoveStrategy {
                override fun isMovable(): Boolean {
                    return true
                }
            })
            then("position이 증가한다.") {
                cars.tryMoveCars()
                cars.getCarsPosition() shouldBe listOf(1, 1, 1, 1)
            }
        }
        `when`("전진 조건을 만족하지 않을때") {
            val cars = Cars(List(4) { Car() }, object: CarMoveStrategy {
                override fun isMovable(): Boolean {
                    return false
                }
            })
            then("postion을 증가하지 않는다.") {
                cars.tryMoveCars()
                cars.getCarsPosition() shouldBe listOf(0, 0, 0, 0)
            }
        }
    }
})
