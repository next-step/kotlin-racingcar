package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class RacingGameTest : DescribeSpec({

    describe("start") {
        context("두 번의 횟수가 주어졌을 때") {
            it("최대 두 번 게임을 진행할 수 있다") {
                val sut = RacingGame(Cars(listOf(Car())), 2)
                shouldNotThrow<Exception> {
                    sut.start()
                    sut.start()
                }
            }

            it("세 번 게임을 진행하면 예외가 발생한다") {
                val sut = RacingGame(Cars(listOf(Car())), 2)
                shouldThrow<IllegalStateException> {
                    sut.start()
                    sut.start()
                    sut.start()
                }
            }
        }
    }

    describe("isNotEnd") {
        context("두 번의 횟수가 주어졌을 때") {
            it("한 번 게임을 진행하면 게임은 종료되지 않는다") {
                val sut = RacingGame(Cars(listOf(Car())), 2)
                sut.start()
                sut.isNotEnd() shouldBe true
            }

            it("두 번 게임을 진행하면 게임이 종료된다") {
                val sut = RacingGame(Cars(listOf(Car())), 2)
                sut.start()
                sut.start()
                sut.isNotEnd() shouldBe false
            }
        }
    }

    describe("record") {
        it("게임 기록를 조회할 수 있다") {
            val sut = RacingGame(Cars(listOf(Car())), 2)
            sut.record shouldNotBe null
        }
    }
})
