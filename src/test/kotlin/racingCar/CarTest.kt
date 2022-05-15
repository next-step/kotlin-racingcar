package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({
    describe("moveFor") {
        it("position 을 1만큼 증가시킨다.") {
            //given
            val car = Car(StubRandom(5))

            // when
            car.moveFor(1)

            // then
            car.position shouldBe 1
        }

        context("시도 횟수가 여러번일 때") {
            it("시도 횟수만큼 position 을 증가시킨다.") {
                //given
                val car = Car(StubRandom(5))

                // when
                car.moveFor(2)

                // then
                car.position shouldBe 2
            }
        }

        context("랜덤으로 생성한 숫자가 4 미만일 때") {
            it("position 은 증가시키지 않는다.") {
                //given
                val car = Car(StubRandom(3))

                // when
                car.moveFor(1)

                // then
                car.position shouldBe 0
            }
        }
    }
})


class StubRandom(private val num: Int) : IRandom {
    override fun generate() = num
}