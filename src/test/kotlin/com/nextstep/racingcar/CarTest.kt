package com.nextstep.racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    val car = Car()

    "Only if number parameter is 4 or more, move fun returns true" {
        forAll(
            row(0, false),
            row(3, false),
            row(4, true),
            row(9, true)
        ) { number, move ->
            car.move(number) shouldBe move
        }
    }

    "If less than 0 or over 9 is passed, move fun throws exception" {
        forAll(
            row(-1),
            row(10)
        ) { number ->
            shouldThrow<IllegalArgumentException> { car.move(number) }
        }
    }
})
