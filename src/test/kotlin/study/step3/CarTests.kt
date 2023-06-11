package study.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTests {

    @Test
    fun `차의 초기 트레이스는 한 칸이다`() {
        val sut = Car(RandomMovementConditionGenerator())
        assertEquals(sut.getMovementTrace(), "")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 미만의 조건에 대해서는 제자리에 있는다`(generatedNumber: Int) {
        val sut = Car(object : MovementConditionGenerator {
            override fun run(): Int {
                return generatedNumber
            }
        })
        sut.move()
        assertEquals(sut.getMovementTrace(), "-")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `4 이상의 조건에 대해서는 한 칸 전진한다`(generatedNumber: Int) {
        val sut = Car(object : MovementConditionGenerator {
            override fun run(): Int {
                return generatedNumber
            }
        })
        sut.move()
        assertEquals(sut.getMovementTrace(), "")
    }
}
