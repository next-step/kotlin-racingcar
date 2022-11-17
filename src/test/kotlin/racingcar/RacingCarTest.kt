package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.InputName
import racingcar.domain.InputNumber

internal class RacingCarTest {
    @Test
    fun `횟수 0 이하 입력 시 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            InputNumber("-1")
        }
    }

    @Test
    fun `자동차 이름 입력이 정상적으로 된다`() {
        assertAll(
            {
                assertEquals("james", InputName("james").names[0])
            },
            {
                val inputName = InputName("Korea,Japan,USA")
                for ((index, name) in inputName.names.withIndex()) {
                    assertEquals(name, inputName.names[index])
                }
            }
        )
    }

    @Test
    fun `자동차 이름 입력 시 공백이면 예외가 발생한다`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,,USA")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea, ,USA")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName(",Korea,USA")
                }
            }
        )
    }

    @Test
    fun `자동차 이름 5자 초과 시 예외가 발생한다`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("coffee")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,HappyMan,USA")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,American")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Horizon,Korea,USA")
                }
            }
        )
    }
}
