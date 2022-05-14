package racingcar.engine

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll

internal class RandomEngineTest : StringSpec({
    "전진하는 거리는 0 또는 1 이어야 한다" {
        val engine = RandomEngine()

        val result = List(1000) { engine.accelerate() }

        result shouldContainAll listOf(0, 1)
    }
})
