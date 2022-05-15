package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("생성자 단위테스트") {
        test("생성된 car 객체는 입력받은 number와 currentLocation 초기값 0을 가진다") {
            // given
            val carNumber = 5
            // when
            val carInstance = Car(carNumber)
            // then
            carInstance.number shouldBe 5
            carInstance.currentLocation shouldBe 0
        }
    }
    context("move 단위테스트") {
        test("move를 호출할때마다 해당 car객체의 currentLocation은 1씩 증가한다") {
            // given
            val carInstance = Car(5)
            // when, then
            carInstance.currentLocation shouldBe 0
            carInstance.move()
            carInstance.currentLocation shouldBe 1
            carInstance.move()
            carInstance.currentLocation shouldBe 2
            carInstance.move()
            carInstance.currentLocation shouldBe 3
        }
    }
})
