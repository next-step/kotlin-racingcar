package racingcar.engine

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.doubles.shouldBeWithinPercentageOf

internal class RandomEngineTest : StringSpec({
    "발생하는 속력는 0 또는 1 이어야 한다" {
        val engine = RandomEngine()

        val result = List(1000) { engine.accelerate() }

        result.forAll { it.value shouldBeIn listOf(0, 1) }
    }

    "60% 확률로 1 속력이 발생한다" {
        val engine = RandomEngine()
        val tries = 10000

        val result = List(tries) { engine.accelerate() }

        val moveCount = result.count { it.value == 1 }
        (moveCount / tries.toDouble()).shouldBeWithinPercentageOf(0.6, 1.0)
    }
})
