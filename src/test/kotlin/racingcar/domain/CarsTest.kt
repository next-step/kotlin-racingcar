package racingcar.domain

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.fixture.ALWAYS_MOVING_STRATEGY
import racingcar.fixture.NEVER_MOVING_STRATEGY

class CarsTest {

    @Test
    fun `자동차 이름 문자열을 받아 자동차 목록을 생성한다`() {
        val names = listOf("a", "b", "c")

        val cars = Cars.of(ALWAYS_MOVING_STRATEGY, names)

        cars.shouldNotBeNull()
    }

    @Test
    fun `성공하는 전략을 주입받아 자동차들을 이동한다`() {
        val names = listOf("a", "b", "c")
        val cars = Cars.of(ALWAYS_MOVING_STRATEGY, names)
        cars.moveAll()

        val positions = cars.getPositions()

        positions.shouldBe(List(3) { 1 })
    }

    @Test
    fun `실패하는 전략을 주입받아 자동차들을 정지한다`() {
        val names = listOf("a", "b", "c")
        val cars = Cars.of(NEVER_MOVING_STRATEGY, names)
        cars.moveAll()

        val positions = cars.getPositions()

        positions.shouldBe(List(3) { 0 })
    }
}
