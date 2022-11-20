package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.RandomMoveRule
import io.kotest.core.spec.style.StringSpec

class RandomMoveRuleTest : StringSpec({
    val randomMoveRule = RandomMoveRule()

    // "Only if number parameter is 4 or more, movable fun returns MOVE. Otherwise it returns NONE" {
    //     forAll(
    //         row(MoveRule{}, Movement.NONE),
    //         row(3, Movement.NONE),
    //         row(4, Movement.MOVE),
    //         row(9, Movement.MOVE)
    //     ) { number, movement ->
    //         every { numberGenerator.generate() } returns number
    //         randomMoveRule.move() shouldBe movement
    //     }
    // }
    //
    // "If less than 0 or over 9 is passed, movable fun throws exception" {
    //     forAll(
    //         row(-1),
    //         row(10)
    //     ) { number ->
    //         every { numberGenerator.generate() } returns number
    //         shouldThrow<IllegalArgumentException> { randomMoveRule.move() }
    //     }
    // }
})
