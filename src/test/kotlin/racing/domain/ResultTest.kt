package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.should
import io.kotest.matchers.types.beInstanceOf

class ResultTest : StringSpec() {
    init {
        "Result 는 Positions 을 가질 수 있다" {
            val result = Result()

            result.add(Positions(listOf(Position(1), Position(2))))
            result.add(Positions(listOf(Position(3), Position(4))))

            result.positionsList should beInstanceOf<List<Positions>>()
            result.positionsList[0].positions shouldContainExactly listOf(Position(1), Position(2))
            result.positionsList[1].positions shouldContainExactly listOf(Position(3), Position(4))
        }
    }
}
