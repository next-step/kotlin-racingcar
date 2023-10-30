package racing

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("자동차 이름이") {
        val carName = "abcdefg"
        `when`("5자를 초과한 경우") {
            then("IllegalArgumentException throw") {
                shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 5자를 초과할 수 없습니다.") {
                    Car(carName)
                }
            }
        }
    }

    given("무작위 값이 4 이상일 때 1만큼 전진하는 자동차의 현재 위치가 1이다") {
        var position = 1
        val car = Car("name", _position = position)
        `when`("무작위 값이 4라고 하면") {
            val random = 4
            car.moveOrStop(random)
            then("자동차는 1만큼 전진하였는가") {
                position += 1
                car.position.shouldBe(position)
            }
        }

        `when`("무작위 값이 2라고 하면") {
            val random = 2
            car.moveOrStop(random)
            then("자동차의 위치는 직전과 동일한가") {
                car.position.shouldBe(position)
            }
        }

        `when`("직전 상태에서 자동차가 2번 이동했다고 할때") {
            for (i in 0 until 2) {
                car.moveOrStop(4)
                position += 1
            }
            then("이동 횟수만큼 실행 결과인 '-'가 반복 되는가") {
                ResultView.transformResult(car.position) shouldBe "----"
            }
        }
    }
})
