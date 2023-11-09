package racing.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("자동차는") {
        `when`("이름과 위치를") {
            forAll(
                row("pobi", 1),
                row("crong", 5),
                row("honux", 10)
            ) { name, position ->
                then("가진다") {
                    val car = Car.of(name, position)
                    car.name shouldBe name
                    car.position shouldBe position
                }
            }
        }

        `when`("이름이 5자를 초과하면") {
            then("예외가 발생한다") {
                shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 5자를 초과할 수 없습니다.") {
                    Car.of(name = "pobicronghonux")
                }
            }
        }

        `when`("초기 위치는") {
            then("1이다") {
                val car = Car.of(name = "pobi")
                car.position shouldBe 1
            }
        }

        `when`("무작위 값이 4 이상일 경우") {
            forAll(
                row(4),
                row(5),
                row(6),
                row(7),
                row(8),
                row(9),
            ) { condition ->
                val car = Car.of("pobi")
                car.moveOrStop(condition)
                then("움직인다") {
                    car.position shouldBe 2
                }
            }
        }

        `when`("무작위 값이 3 이하일 경우") {
            forAll(
                row(0),
                row(1),
                row(2),
                row(3)
            ) { condition ->
                val car = Car.of(name = "pobi")
                car.moveOrStop(condition)
                then("정지한다") {
                    car.position shouldBe 1
                }
            }
        }
    }

    given("자동차의 이름은") {
        val carNames = "pobi,crong,honux"
        then("쉼표로 구분한다") {
            val cars = carNames.split(",").map { name ->
                Car.of(name)
            }
            cars.map { it.name } shouldBe carNames.split(",")
        }
    }
})
