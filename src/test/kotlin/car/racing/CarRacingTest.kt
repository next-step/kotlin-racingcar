package car.racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CarRacingTest : FreeSpec({

    "입력 화면" - {
        fun fakeConsole(@Suppress("UNUSED_PARAMETER") msg: String) = Unit

        "정상 입력으로 진행" - {
            var fakeReadValue: Int? = 0
            fun fakeReader(): String? = fakeReadValue?.toString()
            val inputView = InputView(::fakeReader, ::fakeConsole)

            "드라이버는 5명" {
                fakeReadValue = 5
                inputView.readDrivers() shouldBe fakeReadValue
            }

            "이동횟수는 3번" {
                fakeReadValue = 3
                inputView.readMoves() shouldBe fakeReadValue
            }
        }

        "비정상 입력으로 진행" - {
            var fakeReadValue: String? = null
            fun fakeReader(): String? = fakeReadValue
            val inputView = InputView(::fakeReader, ::fakeConsole)

            fakeReadValue = "a"
            "드라이버는 숫자가 아니기 때문에 IllegalArgumentException 발생" {
                shouldThrowExactly<IllegalArgumentException> {
                    inputView.readDrivers()
                }
            }

            fakeReadValue = "error"
            "이동횟수는 숫자가 아니기 때문에 IllegalArgumentException 발생" {
                shouldThrowExactly<IllegalArgumentException> {
                    inputView.readMoves()
                }
            }

            fakeReadValue = null
            "드라이버는 null 이기 때문에 IllegalArgumentException 발생" {
                shouldThrowExactly<IllegalArgumentException> {
                    inputView.readDrivers()
                }
            }

            "이동횟수는 null 이기 때문에 IllegalArgumentException 발생" {
                shouldThrowExactly<IllegalArgumentException> {
                    inputView.readMoves()
                }
            }
        }
    }

    "결과 화면" - {
        var recordCount = 0
        fun fakeConsole(msg: String) {
            recordCount += 1
        }

        val resultView = ResultView(::fakeConsole)

        "빈 경기결과는 1번 기록되어 있다" {
            recordCount = 0
            resultView.showRecords(GameRecords())
            recordCount shouldBe 1
        }

        "유효한 경기는 1번 이상 기록되어 있다" {
            recordCount = 0
            val drivers = 3
            val cars = Cars(drivers).apply { repeat(10) { runAll() } }
            val records = GameRecords().apply { record(cars) }
            resultView.showRecords(records)
            recordCount shouldBeGreaterThanOrEqual 1
        }
    }
        }
    }

    "자동차는" - {
        "앞으로 이동할 수 있다" {
            val car = Car()
            repeat(10) {
                car.run()
            }
            car.moves shouldBeGreaterThanOrEqual 0
        }

        "낮은 임계점인경우 시도횟수와 동일하게 앞으로 이동할 수 있다" {
            val car = Car(forwardThreshold = 0)
            val trying = 10
            repeat(trying) {
                car.run()
            }
            car.moves shouldBe trying
        }

        "허용 임계 초과로 설정한 경우 IllegalArgumentException 발생" {
            val car = Car(forwardThreshold = 10)
            shouldThrowExactly<IllegalArgumentException> {
                car.run()
            }
        }

        "허용 임계 미만으로 설정한 경우 IllegalArgumentException 발생" {
            val car = Car(forwardThreshold = -1)
            shouldThrowExactly<IllegalArgumentException> {
                car.run()
            }
    "자동차들은" - {
        "드라이버의 수만큼 이동거리를 알 수 있다" {
            val drivers = 199
            val cars = Cars(drivers = drivers)
            cars.runAll()
            cars.getAllMove().size shouldBe drivers
        }
        "한번도 이동하지 않으면 모두 이동거리가 0이다" {
            val cars = Cars(drivers = 10)
            cars.getAllMove().all { it == 0 } shouldBe true
        }
    }

    "경기 기록은" - {
        val drivers = 3
        val cars = Cars(drivers)
        val records = GameRecords()

        records.reset()
        "기록횟수를 알 수 있다" {
            records.record(cars)
            records.records.size shouldBe 1
        }

        records.reset()
        "기록은 초기화 할 수 있다" {
            records.record(cars)
            records.reset()
            records.records.size shouldBe 0
        }
    }

    "자동차 경주" - {
        val racing = CarRacing()

        "새 게임을 생성하고 시작하면" - {
            val game = racing.newGame(drivers = 1, moves = 1)
            "완료하고 결과를 반환" {
                val result = game.play()
                result.records.size shouldNotBe 0
            }
        }

        "드라이버가 명수가 유효하지 않은 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                racing.newGame(drivers = 0, moves = 1)
            }
        }

        "시도 횟수가 유효하지 않은 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                racing.newGame(drivers = 1, moves = 0)
            }
        }
    }
})
