package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarRacingTest : BehaviorSpec({
    given("몇 대의 자동차로 경주를 할 것인지를 전달하면") {
        val carCount = 3
        then("그에 맞는 배열이 생성되는가") {
            CarRacing.createCars(carCount) shouldBe List(carCount) { Car() }
        }
    }

    given("0에서 9 사이에서 무작위 값을 구한 후") {
        val random = Car.random(0..9)
        `when`("무작위 값이 4 이상인 경우") {
            then("전진할 수 있는가") {
                Car.isMove { random }.shouldBe(random >= 4)
            }
        }
    }

    given("자동차가 이동한 횟수만큼") {
        val moveCount = 3
        then("실행 결과인 '-'가 반복 되는가") {
            val car = Car()
            ResultView.transformResult(car.position) shouldBe "-"
            for (i in 0 until moveCount) {
                car.move()
            }
            ResultView.transformResult(car.position) shouldBe "----"
        }
    }
})
