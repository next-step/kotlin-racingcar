package com.nextstep.racingcar.domain.rules

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class NumberMoveRuleTest : StringSpec({

    "Only if number parameter is 4 or more, movable fun returns MOVE. Otherwise it returns NONE" {
        forAll(
            row(1, NONE),
            row(3, NONE),
            row(4, MOVE),
            row(9, MOVE)
        ) { number, movement ->
            val numberGenerator = mockk<NumberGenerator>()
            every { numberGenerator.generate() } returns number
            val numberMoveRule = NumberMoveRule(numberGenerator)

            numberMoveRule.move() shouldBe movement
        }
    }

    "If less than 0 or over 9 is passed, movable fun throws exception" {
        forAll(
            row(NumberGenerator { -1 }),
            row(NumberGenerator { 10 })
        ) { invalidNumberGenerator ->
            val numberMoveRule = NumberMoveRule(invalidNumberGenerator)
            shouldThrow<IllegalArgumentException> { numberMoveRule.move() }
        }
    }
})
