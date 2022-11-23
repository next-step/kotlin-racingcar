package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import com.nextstep.racingcar.domain.rules.MoveRule
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class CarTest : StringSpec({

    "Car#constructor exception test: car name should be shorter than 6 letters and not empty" {
        forAll(
            row("long name"),
            row(""),
            row("    ")
        ) { name ->
            shouldThrow<IllegalArgumentException> {
                Car(name)
            } shouldHaveMessage "car name should be shorter than 6 letters and not empty"
        }
    }

    "If car is called, car delegate moveRule to move" {
        val car = Car("sujin")
        val moveRule = mockk<MoveRule>()
        every { moveRule.move() } returns MOVE

        car.move(moveRule)

        verify(exactly = 1) { moveRule.move() }
    }

    "Car can give user's history" {
        forAll(
            row(MoveRule { NONE }, NONE),
            row(MoveRule { MOVE }, MOVE)
        ) { moveRule, movement ->
            val car = Car("sujin")

            car.move(moveRule)

            car.getHistories() shouldContainExactly listOf(movement)
        }
    }

    "Car can give user's location info" {
        val car = Car("쪼밀리")
        val movingRule = MoveRule { MOVE }
        val notMovingRule = MoveRule { NONE }

        car.move(movingRule)
        car.move(notMovingRule)

        val location = car.getLocation()

        location shouldBe 1
    }
})
