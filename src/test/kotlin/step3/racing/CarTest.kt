package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({
  it("생성된 자동차의 거리는 0이다.") {
    val car = Car()

    car.distance shouldBe 0
  }

  it("이동시 거리가 1 증가한다.") {
    val car = Car(3)

    car.move()

    car.distance shouldBe 4
  }
})
