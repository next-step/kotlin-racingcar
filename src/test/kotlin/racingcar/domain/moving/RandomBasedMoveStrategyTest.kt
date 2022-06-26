package racingcar.domain.moving

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomBasedMoveStrategyTest : AnnotationSpec() {
    @Test
    fun `0 - 9 사이 랜덤 숫자 하나를 반환한다`() {
        // given
        // when
        val randomNumber = RANDOM_NUMBER_RANGE.random()
        // then
        randomNumber shouldBeInRange 0..9
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
        private const val MAXIMUM_NUMBER = 9
        private val RANDOM_NUMBER_RANGE = MINIMUM_NUMBER..MAXIMUM_NUMBER
    }
}
