package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class CarTest : StringSpec({
    val car = Car()
    val numberGenerator = mockk<NumberGenerator>()
    val moveRule = mockk<NumberMoveRule>()

    "Car#move returns Movement Enum meaning thee car moved or not" {
        every { numberGenerator.generate() } returns 5
        every { moveRule.move(5) } returns MOVE

        car.move(numberGenerator, moveRule)

        verify { numberGenerator.generate() }
        verify { moveRule.move(any()) }
    }

    "car can save movement histories" {
        car.saveHistory(MOVE)
        car.saveHistory(MOVE)
        car.saveHistory(NONE)

        car.getHistories() shouldContainExactly listOf(MOVE, MOVE, NONE)
    }
})
