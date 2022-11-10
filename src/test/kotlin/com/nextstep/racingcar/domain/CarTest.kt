package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class CarTest : StringSpec({
    val car = Car()
    val randomIntGenerator = mockk<RandomIntGenerator>()

    "Only if number parameter is 4 or more, move fun returns true" {

        forAll(
            row(0, NONE),
            row(3, NONE),
            row(4, MOVE),
            row(9, MOVE)
        ) { number, movement ->
            every { randomIntGenerator.generate() } returns number
            car.move(randomIntGenerator) shouldBe movement
        }
    }

    "If less than 0 or over 9 is passed, move fun throws exception" {
        forAll(
            row(-1),
            row(10)
        ) { number ->
            every { randomIntGenerator.generate() } returns number
            shouldThrow<IllegalArgumentException> { car.move(randomIntGenerator) }
        }
    }

    "car can save movement histories" {
        car.saveHistory(MOVE)
        car.saveHistory(MOVE)
        car.saveHistory(NONE)

        car.getHistories() shouldContainExactly listOf(MOVE, MOVE, NONE)
    }
})
