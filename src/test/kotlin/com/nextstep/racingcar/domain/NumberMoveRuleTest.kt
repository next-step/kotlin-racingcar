package com.nextstep.racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberMoveRuleTest : StringSpec({
    val numberMoveRule = NumberMoveRule()

    "Only if number parameter is 4 or more, movable fun returns MOVE. Otherwise it returns NONE" {
        forAll(
            row(0, Movement.NONE),
            row(3, Movement.NONE),
            row(4, Movement.MOVE),
            row(9, Movement.MOVE)
        ) { number, movement ->
            numberMoveRule.move(number) shouldBe movement
        }
    }

    "If less than 0 or over 9 is passed, movable fun throws exception" {
        forAll(
            row(-1),
            row(10)
        ) { number ->
            shouldThrow<IllegalArgumentException> { numberMoveRule.move(number) }
        }
    }
})
