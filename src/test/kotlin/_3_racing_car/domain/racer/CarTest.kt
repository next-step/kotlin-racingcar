package _3_racing_car.domain.racer

import _3_racing_car.domain.Name
import _3_racing_car.domain.Position
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class CarTest : ExpectSpec() {
    init {
        context("move") {
            expect("전진 조건에 만족하면 위치가 변한다.") {
                forAll(
                    row("a", 1, 4, "a" to 2),
                    row("b", 1, 5, "b" to 2),
                    row("c", 2, 5, "c" to 3),
                ) {
                    name, position, power, expected ->

                    val car = Car(name = Name(name), position = Position(position))

                    val movePosition = car.move(power)

                    car.name shouldBe Name(expected.first)
                    movePosition shouldBe Position(expected.second)
                }
            }

            expect("전진 조건에 만족하지 않으면 위치가 유지한다.") {
                forAll(
                    row(1, 3, 1),
                    row(2, 3, 2),
                ) {
                    position, power, expected ->

                    val car = Car(position = Position(position))

                    val movePosition = car.move(power)

                    movePosition shouldBe Position(expected)
                }
            }
        }
    }
}
