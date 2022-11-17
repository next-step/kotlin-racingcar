package racingcar

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.*

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

    @Test
    fun `이름 중복 시 예외가 발생한다`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,Japan,Korea,China")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,USA,USA")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,Tiger,Lion,Horse,Korea")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    InputName("Korea,Korea,USA")
                }
            }
        )
    }

    @ParameterizedTest
    @CsvSource("'Korea,Japan,China', '5'")
    fun `우승자 선택 및 출력한다`(names: String, games: String) {
        val inputNameOfCars = InputName(names).names
        val inputNumberOfTGames = InputNumber(games).number
        val gameInputValue = GameInputValue(inputNameOfCars, inputNumberOfTGames)
        assertAll(
            {
                val cars = Cars()
                cars.make(inputNameOfCars, MockStrategy(KOREA_CAR_NUMBER))
                cars.race(gameInputValue)
                assertEquals("Korea", cars.showResult())
            },
            {
                val cars = Cars()
                cars.make(inputNameOfCars, MockStrategy(JAPAN_CAR_NUMBER))
                cars.race(gameInputValue)
                assertEquals("Japan", cars.showResult())
            },
            {
                val cars = Cars()
                cars.make(inputNameOfCars, MockStrategy(CHINA_CAR_NUMBER))
                cars.race(gameInputValue)
                assertEquals("China", cars.showResult())
            },
            {
                val cars = Cars()
                cars.make(inputNameOfCars, MockStrategy(ALL_CAR_STOP_WINNER_NUMBER))
                cars.race(gameInputValue)
                assertEquals("Korea, Japan, China", cars.showResult())
            },
            {
                val cars = Cars()
                cars.make(inputNameOfCars, MockStrategy(ALL_CAR_MOVE_WINNER_NUMBER))
                cars.race(gameInputValue)
                assertEquals("Korea, Japan, China", cars.showResult())
            }
        )
    }

    companion object {
        const val KOREA_CAR_NUMBER = 0
        const val JAPAN_CAR_NUMBER = 1
        const val CHINA_CAR_NUMBER = 2
        const val ALL_CAR_STOP_WINNER_NUMBER = 3
        const val ALL_CAR_MOVE_WINNER_NUMBER = 4
    }
}
