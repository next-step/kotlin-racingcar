package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import com.nextstep.racingcar.domain.rules.MoveRule
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CarsTest : StringSpec({

    "exception test: car name should be shorter than 6 letters and not empty" {
        shouldThrow<IllegalArgumentException> {
            Cars(setOf("longname"))
        } shouldHaveMessage "car name should be shorter than 6 letters and not empty"
    }

    "Cars#play fun move all cars once each" {
        val names = setOf("수진", "쪼밀리", "코틀린")
        val moveRule = MoveRule { MOVE }
        val cars = Cars(names)

        val before = cars.getHistories()
        before shouldContainExactly listOf(
            Pair("수진", emptyList()),
            Pair("쪼밀리", emptyList()),
            Pair("코틀린", emptyList())
        )

        cars.play(moveRule)

        val after = cars.getHistories()
        after shouldContainExactly listOf(
            Pair("수진", listOf(MOVE)),
            Pair("쪼밀리", listOf(MOVE)),
            Pair("코틀린", listOf(MOVE))
        )
    }

    "Cars#getHistories return car name and Movement pairs list" {
        val names = setOf("수진", "쪼밀리", "코틀린")
        val cars = Cars(names)

        val histories = cars.getHistories()

        histories shouldContainExactly listOf(
            Pair("수진", emptyList()),
            Pair("쪼밀리", emptyList()),
            Pair("코틀린", emptyList())
        )
    }

    "Cars can find winners" {
        val movingRule = MoveRule { MOVE }
        val notMovingRule = MoveRule { NONE }

        val sujinCar = Car("수진")
        val chomilyCar = Car("쪼밀리")
        val cars = Cars(listOf(sujinCar, chomilyCar))

        sujinCar.move(movingRule)
        chomilyCar.move(notMovingRule)

        cars.findWinners() shouldBe listOf(sujinCar)
    }
})
