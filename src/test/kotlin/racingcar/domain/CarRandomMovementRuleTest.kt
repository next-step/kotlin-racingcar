package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRandomMovementRuleTest {
    @Test
    fun `moveCarByRule()이 true이면 Car가 Move`() {
        val car = Car("MOCK")
        val mockUpRule = object : CarMovementRule {
            override val rule = { true }
        }
        assertThat(
            mockUpRule.moveCarByRule(car).distance
        ).isEqualTo(1)
    }

    @Test
    fun `moveCarByRule()이 false이면 Car가 Move하지 않음`() {
        val car = Car("MOCK")
        val mockUpRule = object : CarMovementRule {
            override val rule = { false }
        }
        mockUpRule.moveCarByRule(car)
        assertThat(car.distance).isEqualTo(0)
    }
}
