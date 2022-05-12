package _3_racing_car.domain.power

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeInRange
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.exp

internal class RandomPowerTest: ExpectSpec() {
    init {
        context("create") {
            expect("지정한 최소, 최대값 범위안의 랜덤값이 생성된다.") {
                forAll(
                    row(0, 2 ,IntRange(0, 1)),
                    row(1, 3 ,IntRange(1, 3)),
                ) {
                    from, until, expect ->
                    val power = RandomPower()

                    val result = power.create(from, until)

                    result shouldBeInRange expect
                }
            }
        }
    }
}