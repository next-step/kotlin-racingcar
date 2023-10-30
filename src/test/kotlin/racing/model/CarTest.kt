package racing.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import racing.model.move.MoveAlwaysStrategy
import racing.model.move.MoveNeverStrategy

class CarTest : StringSpec({
    "자동차는 전진 또는 멈출 수 있다" {
        val car = Car("77", 77)

        val stopCar = car.move(MoveNeverStrategy())
        stopCar.name shouldBe car.name
        stopCar.position shouldBe car.position

        val unstoppableCar = car.move(MoveAlwaysStrategy())
        unstoppableCar.name shouldBe car.name
        unstoppableCar.position shouldBe car.position + 1
    }

    "각 자동차에 이름을 부여할 수 있다" {

        val namedLength4Car = Car("강한친구", 101)
        val namedLength5Car = Car("강한자동차", 707)

        namedLength4Car.name shouldBe "강한친구"
        namedLength4Car.name.length shouldBe 4
        namedLength5Car.name shouldBe "강한자동차"
        namedLength5Car.name.length shouldBe 5
    }

    "자동차 이름은 5자를 초과할 수 없다 초과시 IllegalArgumentException throw" {

        shouldThrow<IllegalArgumentException> {
            Car("자동차자동차", 101)
        }.shouldHaveMessage("자동차 이름은 5자를 초과할 수 없다 : [자동차자동차] 은 [6] 자 입니다")

        shouldThrow<IllegalArgumentException> {
            Car("힘이세고강한친구", 101)
        }.shouldHaveMessage("자동차 이름은 5자를 초과할 수 없다 : [힘이세고강한친구] 은 [8] 자 입니다")
    }

    "자동차 이름이 공백 인경우 IllegalArgumentException throw" {
        TODO()
    }

    "자동차 이름이 null 인경우 IllegalArgumentException throw" {
        TODO()
    }
})
