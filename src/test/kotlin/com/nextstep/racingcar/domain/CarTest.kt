package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE
import com.nextstep.racingcar.domain.Movement.NONE
import com.nextstep.racingcar.domain.rules.MoveRule
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly

class CarTest : StringSpec({

    "Car#move returns Movement Enum meaning the car moved or not" {
        forAll(
            row(MoveRule { NONE }, NONE),
            row(MoveRule { MOVE }, MOVE)
        ) { moveRule, movement ->
            val car = Car()

            car.move(moveRule)

            car.getHistories() shouldContainExactly listOf(movement)
        }
    }
})
