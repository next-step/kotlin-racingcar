package carrace.logic.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Winners
 */
class WinnersTest : FunSpec({

    context("Winners 단위 테스트") {
        val defaultCarName = CarName("car1")
        val defaultCar = Car(defaultCarName)

        test("getResult") {
            val winners = Winners(listOf(defaultCar))

            winners.getResult() shouldBe "car1가 최종 우승했습니다."
        }
    }
})
