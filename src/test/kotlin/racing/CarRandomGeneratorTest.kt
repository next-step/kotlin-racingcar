package racing

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange
import racing.domain.RacingGame

class CarRandomGeneratorTest : AnnotationSpec() {

    @Test
    fun `0에서 9 사이에서 무작위 값을 구한다`() {
        repeat(5) {
            CarRandomGenerator.createRandom(RacingGame.MAX_BOUND) shouldBeInRange 0..9
        }
    }
}
