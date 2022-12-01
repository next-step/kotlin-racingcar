package carrace.logic.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Winners
 */
internal class WinnersTest : FunSpec({

    context("Winners 단위 테스트") {
        val defaultCarName = CarName("car1")
        val defaultCar = Car(defaultCarName)

        test("getResult") {
            val winners = Winners(listOf(defaultCar))

            winners.cars[0] shouldBe defaultCar
        }
    }
})
