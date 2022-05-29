package _3_racing_car.service.dto

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

internal class RacingOutputDtoTest : ExpectSpec() {
    init {
        context("winners") {
            expect("가장 먼 거리를 간 경주자가 우승자가 된다.") {
                val racers = mapOf("A" to 3, "B" to 4, "C" to 5)

                val result = RacingOutputDto(racers)

                result.winners shouldBe listOf("C")
            }

            expect("다수의 우승자가 나올수 있다.") {
                val racers = mapOf("A" to 3, "B" to 4, "C" to 5, "D" to 5)

                val result = RacingOutputDto(racers)

                result.winners shouldBe listOf("C", "D")
            }
        }
    }
}
