package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CarTest : StringSpec({

    "Car#constructor exception test: car name should be shorter than 6 letters and not empty" {
        forAll(
            row("long name"),
            row(""),
            row("    ")
        ) { name ->
            shouldThrow<IllegalArgumentException> {
                Car(name)
            } shouldHaveMessage "car name should be shorter than 6 letters and not empty, name: $name"
        }
    }

    "If car is called, car delegate moveRule to move" {
        val car = Car("sujin")

        car.move { MOVE }

        car.getLocation() shouldBe 1
    }

    "Car can give user's history" {
        forAll(
            row(NONE),
            row(MOVE)
        ) { movement ->
            val moveHistory = MoveHistory()
            moveHistory.saveHistory(movement)

            val car = Car("sujin", moveHistory)

            car.getHistories() shouldContainExactly listOf(movement)
        }
    }

    "Car can give user's location info" {
        val moveHistory = MoveHistory()
        moveHistory.saveHistory(MOVE)
        moveHistory.saveHistory(MOVE)
        moveHistory.saveHistory(NONE)

        val car = Car("쪼밀리", moveHistory)

        val location = car.getLocation()

        location shouldBe 2
    }
})
