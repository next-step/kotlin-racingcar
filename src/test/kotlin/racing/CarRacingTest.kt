package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarRacingTest : BehaviorSpec({
    given("몇 대의 자동차로 몇 번의 이동을 할 것인지를 전달하면") {
        then("그에 맞는 이차원 배열이 생성되는가") {
            forAll(
                row(3, 5),
                row(5, 5)
            ) { carCount, tryCount ->
                InputView.create(tryCount, carCount) shouldBe List(tryCount) { List(carCount) { Car() } }
            }
        }
    }

    given("0에서 9 사이에서 무작위 값을 구한 후") {
        val random = CarRacing.random(0..9)
        `when`("무작위 값이 4 이상인 경우") {
            then("전진할 수 있는가") {
                CarRacing.isMove { random }.shouldBe(random >= 4)
            }
        }
    }

    given("자동차가 이동한 횟수만큼") {
        then("실행 결과인 '-'가 반복 되는가") {
            forAll(
                row(3)
            ) { moveCount ->
                val car = Car()
                car.getResult() shouldBe "-"
                for (i in 0 until moveCount) {
                    car.move()
                }
                car.getResult() shouldBe "----"
            }
        }
    }
})
