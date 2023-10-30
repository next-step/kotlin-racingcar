package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec ({
    given("Cars 객체는"){
        val cars = Cars(3)
        `when`("4 미만의 일정한 값이 주어졌을 때"){
            cars.moveAll { 3 }
            then("모두 함께 정지한다."){
                cars.carList.forEach { car ->
                    car.currentPosition shouldBe 1
                }
            }
        }

        `when`("4 이상의 일정한 값이 주어졌을 때"){
            cars.moveAll { 5 }
            then("모두 함께 움직인다."){
                cars.carList.forEach { car ->
                    car.currentPosition shouldBe 2
                }
            }
        }
    }

})