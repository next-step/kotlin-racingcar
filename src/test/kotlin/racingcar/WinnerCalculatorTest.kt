package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class WinnerCalculatorTest : FunSpec({
    context("우승한 자동차를 계산하는 기능 테스트") {
        context("여러 대의 자동차 중에서") {
            test("우승한 자동차를 반환할 수 있다.") {
                // given
                val carA = Car(id = 1, name = CarName(value = "동구"), position = Position(value = 6))
                val carB = Car(id = 2, name = CarName(value = "상근"), position = Position(value = 4))
                val carC = Car(id = 3, name = CarName(value = "주덕"), position = Position(value = 3))
                val carD = Car(id = 4, name = CarName(value = "재혁"), position = Position(value = 2))
                // when
                val actual = WinnerCalculator.execute(cars = listOf(carA, carB, carC, carD))
                // then
                actual shouldContainExactly listOf(carA)
            }

            context("우승한 자동차가 여러 대인 경우") {
                test("여러 대의 자동차를 반환할 수 있다.") {
                    // given
                    val carA = Car(id = 1, name = CarName(value = "동구"), position = Position(value = 6))
                    val carB = Car(id = 2, name = CarName(value = "상근"), position = Position(value = 6))
                    val carC = Car(id = 3, name = CarName(value = "주덕"), position = Position(value = 3))
                    val carD = Car(id = 4, name = CarName(value = "재혁"), position = Position(value = 2))
                    // when
                    val actual = WinnerCalculator.execute(cars = listOf(carA, carB, carC, carD))
                    // then
                    actual shouldContainExactly listOf(carA, carB)
                }
            }
        }
    }
})
