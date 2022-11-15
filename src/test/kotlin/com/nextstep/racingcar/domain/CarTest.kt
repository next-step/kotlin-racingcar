package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.NumberGenerator
import com.nextstep.racingcar.domain.rules.NumberMoveRule
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class CarTest : StringSpec({
    val numberGenerator = mockk<NumberGenerator>()
    val moveRule = NumberMoveRule(numberGenerator)

    "Car#move returns Movement Enum meaning thee car moved or not" {
        forAll(
            row(0, Movement.NONE),
            row(3, Movement.NONE),
            row(4, Movement.MOVE),
            row(9, Movement.MOVE)
        ) { number, movement ->
            val car = Car()
            every { numberGenerator.generate() } returns number

            car.move(moveRule)

            car.getHistories() shouldContainExactly listOf(movement)
            verify { numberGenerator.generate() }
            verify { moveRule.move() }
        }
    }
})
