package _3_racing_car.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class WinnerTest : ExpectSpec() {
    init {
        context("find") {
            expect("경주자중 우승자들을 찾는다.") {
                forAll(
                    row(mapOf("A" to 3, "B" to 4, "C" to 5, "D" to 6), listOf("D")),
                    row(mapOf("A" to 3, "B" to 4, "C" to 5, "D" to 5), listOf("C", "D")),
                ) {
                    racers, expect ->
                    val winner = Winner(racers)

                    val result = winner.find()

                    result shouldBe expect
                }
            }
        }
    }
}
