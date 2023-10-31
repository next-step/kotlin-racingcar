package racing.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.moveprovider.MoveForwardProvider
import racing.moveprovider.StopMoveProvider

class CarsTest : BehaviorSpec ({
    given("Cars 객체는") {
        val cars = Cars(3)
        `when`("4 미만의 일정한 값이 주어졌을 때") {
            cars.moveAll(StopMoveProvider())
            then("모두 함께 정지한다.") {
                cars.carList.forEach { car ->
                    car.currentPosition shouldBe 1
                }
            }
        }

        `when`("4 이상의 일정한 값이 주어졌을 때"){
            cars.moveAll(MoveForwardProvider())
            then("모두 함께 움직인다."){
                cars.carList.forEach { car ->
                    car.currentPosition shouldBe 2
                }
            }
        }
    }

    given("Car의 모임인 Cars 객체에서") {
        val cars = Cars(
            listOf(Car(5), Car(4), Car(3), Car(5))
        )
        `when`("가장 멀리 가 있는 자동차는") {
            val winner: List<Car> = cars.getWinner()
            then("position 이 5인 객체들이다.") {
                winner.forEach { car ->
                    car.currentPosition shouldBe 5
                }
            }
        }

    }

})