package step3.domain.car

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import step3.domain.formula.BasicRuleMoveFormula
import step3.domain.formula.NotMoveFormula
import java.util.concurrent.atomic.AtomicInteger

class CarTest : DescribeSpec({

    describe(name = "자동차를 생성할 때") {
        val position = 3

        context(name = "위치를 명시적으로 지정하면") {
            val createCar = CarFactory.createCar(position = position, moveFormula = NotMoveFormula)

            it(name = "지정한 위치로 생성된다.") {
                createCar.move(value = position) shouldBe position
            }
        }
    }

    describe(name = "자동차들을 생성할 때") {
        val count = 3

        context(name = "개수를 명시적으로 지정하면") {
            val cars = CarFactory.createCars(count = count, moveFormula = NotMoveFormula)

            it(name = "지정한 개수만큼 생성된다.") {
                cars.size shouldBe count
            }
        }
    }

    describe(name = "기본 룰로 자동차를 생성할 때") {
        val position = AtomicInteger()

        val createCar = CarFactory.createCar(
            position = position.get(),
            moveFormula = BasicRuleMoveFormula,
        )

        context(name = "4이상일 때") {
            val move = 4

            it(name = "한 칸 앞으로 간다.") {
                createCar.move(value = move) shouldBe position.incrementAndGet()
            }
        }

        context(name = "4미만일 때") {
            val move = 3

            it(name = "움직이지 않는다.") {
                createCar.move(value = move) shouldBe position.get()
            }
        }
    }
})
