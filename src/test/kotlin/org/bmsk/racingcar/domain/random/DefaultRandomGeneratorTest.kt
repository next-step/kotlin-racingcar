package org.bmsk.racingcar.domain.random

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeBetween

class DefaultRandomGeneratorTest : FunSpec({

    val randomGenerator = ZeroToNineRandomGenerator()
    test("generate 함수는 0부터 9까지의 숫자를 무작위로 반환한다.") {
        val countMap = mutableMapOf<Int, Int>().apply {
            (0..9).forEach { put(it, 0) }
        }

        repeat(1000) {
            val result = randomGenerator.generate()
            result.shouldBeBetween(0, 9)
            countMap[result] = countMap[result]!! + 1
        }

        println("Generated numbers count:")
        countMap.forEach { (key, value) ->
            println("Number $key: $value times")
        }
    }
})
