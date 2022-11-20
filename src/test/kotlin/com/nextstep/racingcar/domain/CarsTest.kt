package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import com.nextstep.racingcar.domain.rules.MoveRule
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.throwable.shouldHaveMessage

class CarsTest : StringSpec({

    "Cars#getHistories return car name and Movement list pairs" {
        val names = listOf("수진", "쪼밀리", "코틀린")
        val cars = Cars(names)

        val histories = cars.getHistories()

        histories shouldContainExactly listOf(
            Pair("수진", emptyList()),
            Pair("쪼밀리", emptyList()),
            Pair("코틀린", emptyList())
        )
    }

    "exception test: car name should be shorter than 6 letters and not empty" {
        shouldThrow<IllegalArgumentException> {
            Cars(listOf("longname"))
        } shouldHaveMessage "car name should be shorter than 6 letters and not empty"
    }

    "Cars#play fun call car.move and make history" {
        val names = listOf("수진", "쪼밀리", "코틀린")
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

    "Cars can find winners" {
        val names = listOf("수진", "쪼밀리", "코틀린")
        val cars = Cars(names)
        val movingRule = MoveRule { MOVE }
        val notMovingRule = MoveRule { NONE }

        TODO("테스트 어떻게 하지???")
    }
})
