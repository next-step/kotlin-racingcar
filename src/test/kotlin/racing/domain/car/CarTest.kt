package racing.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import racing.domain.formula.NotMoveFormula
import racing.model.RaceGameErrorCode

class CarTest : DescribeSpec({

    describe(name = "자동차를 생성할 때") {
        val position = 3
        val name = "andy"

        context(name = "위치와 이름을 지정하면") {
            val car = CarFactory.createCar(position = position, name = name)

            it(name = "지정한 위치로 생성된다.") {
                car.move(moveFormula = NotMoveFormula) shouldBe position
            }

            it(name = "지정한 이름으로 생성된다.") {
                car.name shouldBe name
            }

            it(name = "현재 자동차 위치를 반환한다.") {
                car.position shouldBe position
            }
        }

        val invalidName = "안녕하세요로로오"

        context(name = "자동차 이름에 5글자를 초과하는 문자열을 입력하면") {
            val exception = shouldThrow<IllegalArgumentException> {
                CarFactory.createCar(position = position, name = invalidName)
            }

            it(name = "자동차 이름은 빈 공백이거나, 정해진 글자 수를 초과할 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.INVALID_CAR_NAME_INPUT.message("$invalidName 5")
            }
        }
    }

    describe(name = "자동차들을 생성할 때") {
        val carNames = listOf("test1", "test2", "test3")

        context(name = "자동차 이름 리스트를 지정하면") {
            val cars = CarFactory.createCars(carNames = carNames)

            it(name = "지정한 이름 순서대로 생성된다.") {
                cars.size shouldBe carNames.size

                cars.forEachIndexed { index, car ->
                    car.name shouldBe carNames[index]
                }
            }
        }
    }
})
