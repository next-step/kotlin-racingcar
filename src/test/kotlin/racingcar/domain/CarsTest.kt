package racingcar.domain

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.fixture.ALWAYS_MOVING_STRATEGY
import racingcar.fixture.NEVER_MOVING_STRATEGY

class CarsTest {

    @Test
    fun `숫자를 받아 자동차 목록을 생성한다`() {
        val cars = Cars.createCountOf(5)

        cars.shouldNotBeNull()
    }

    @Test
    fun `성공하는 전략을 주입받아 자동차들을 이동한다`() {
        val cars = Cars.createCountOf(5)
        cars.moveAll(ALWAYS_MOVING_STRATEGY)

        val positions = cars.getPositions()

        positions.shouldBe(List(5) { 1 })
    }

    @Test
    fun `실패하는 전략을 주입받아 자동차들을 정지한다`() {
        val cars = Cars.createCountOf(5)
        cars.moveAll(NEVER_MOVING_STRATEGY)

        val positions = cars.getPositions()

        positions.shouldBe(List(5) { 0 })
    }
}
