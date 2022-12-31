package domain.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class GameKoTest : DescribeSpec({

    describe("validate method test") {
        context("carAmountValidate test") {
            it("차 갯수가 1개 미만이면 에러가 발생한다") {
                val message = shouldThrow<java.lang.IllegalArgumentException> { Game(emptyList(), 1) }

                message shouldHaveMessage "차 갯수는 1개 이상이여야 합니다."
            }
        }

        context("trialValidate test") {
            it("시도 횟수가 1번 미만이면 에러가 발생한다") {
                val names = listOf(Name("pobi"), Name("jason"), Name("marco"))
                val message = shouldThrow<java.lang.IllegalArgumentException> { Game(names, 0) }

                message shouldHaveMessage "시도 횟수는 1번 이상이여야 합니다."
            }
        }
    }

    describe("method test") {
        context("run test") {
            listOf(4, 5, 6, 7, 8, 9).forEach {
                it("4이상이면 차들이 움직인다") {
                    val names = listOf(Name("pobi"), Name("jason"), Name("marco"))
                    val game = Game(names, 1)

                    game.run { it }

                    val result = game.getResult()

                    result.forEach {
                        it.values.forEach {
                            it shouldBe "-"
                        }
                    }
                }
            }

            listOf(0, 1, 2, 3).forEach {
                it("3미만이면 차들이 움직이지 않는다.") {
                    val names = listOf(Name("pobi"), Name("jason"), Name("marco"))
                    val game = Game(names, 1)

                    game.run { it }

                    val result = game.getResult()

                    result.forEach {
                        it.values.forEach {
                            it shouldBe ""
                        }
                    }
                }
            }
        }
    }
})
