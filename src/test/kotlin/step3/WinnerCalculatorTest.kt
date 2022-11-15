package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class WinnerCalculatorTest : FunSpec({
    context("여러 대의 자동차 중에서") {
        test("우승한 자동차를 반환할 수 있다.") {
            // given
            val relkimmCar = Car(id = 1, name = "relkimm")
            val seulgeunCar = Car(id = 2, name = "seulgeun")
            val duckCar = Car(id = 3, name = "duck")

            relkimmCar.move(oil = Oil(4))
            relkimmCar.move(oil = Oil(4))
            relkimmCar.move(oil = Oil(4))
            seulgeunCar.move(oil = Oil(amount = 4))
            seulgeunCar.move(oil = Oil(amount = 4))
            // when
            val actual = WinnerCalculator.execute(cars = listOf(relkimmCar, seulgeunCar, duckCar))
            // then
            actual shouldContainExactly listOf(relkimmCar)
        }

        context("우승한 자동차가 여러 대인 경우") {
            test("여러 대의 자동차를 반환할 수 있다.") {
                // given
                val relkimmCar = Car(id = 1, name = "relkimm")
                val seulgeunCar = Car(id = 2, name = "seulgeun")
                val duckCar = Car(id = 3, name = "duck")

                relkimmCar.move(oil = Oil(4))
                relkimmCar.move(oil = Oil(4))
                relkimmCar.move(oil = Oil(4))
                seulgeunCar.move(oil = Oil(amount = 4))
                seulgeunCar.move(oil = Oil(amount = 4))
                seulgeunCar.move(oil = Oil(amount = 4))
                // when
                val actual = WinnerCalculator.execute(cars = listOf(relkimmCar, seulgeunCar, duckCar))
                // then
                actual shouldContainExactly listOf(relkimmCar, seulgeunCar)
            }
        }
    }
})
