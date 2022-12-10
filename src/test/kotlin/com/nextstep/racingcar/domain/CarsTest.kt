package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CarsTest : StringSpec({

    "exception test: car name should be shorter than 6 letters and not empty" {
        shouldThrow<IllegalArgumentException> {
            Cars(setOf("longname"))
        } shouldHaveMessage "car name should be shorter than 6 letters and not empty, name: longname"
    }

    "Cars#play fun call move fun at all cars once each" {
        val names = setOf("수진", "쪼밀리", "코틀린")
        val cars = Cars(names)

        cars.cars.forEach {
            it.getLocation() shouldBe 0
        }

        cars.play { MOVE }

        cars.cars.forEach {
            it.getLocation() shouldBe 1
        }
    }

    "Cars can find winners" {
        val winnerHistory = MoveHistory(mutableListOf(MOVE, MOVE, NONE))
        val loserHistory = MoveHistory(mutableListOf(MOVE, NONE, NONE))

        val sujinCar = Car("수진", winnerHistory)
        val chomilyCar = Car("쪼밀리", loserHistory)
        val cars = Cars(listOf(sujinCar, chomilyCar))

        cars.findWinners() shouldBe listOf(sujinCar)
    }
})
