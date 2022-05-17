package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainInOrder

class RaceSpecs : DescribeSpec({

    describe("경주는") {
        context("경주 횟수가 유효하지 않다면") {
            val invalidNumberOfRaces = 0
            it("예외를 발생시킨다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    Race(listOf(Car("name", RandomDriver)), invalidNumberOfRaces)
                }
            }
        }

        context("경주를 진행할 자동차가 없다면") {
            it("예외를 발생시킨다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    Race(emptyList(), 3)
                }
            }
        }

        context("경주에 참여한 자동차가 있고 경주 횟수가 주어진다면") {
            val numberOfRaces = 3
            it("경주를 진행하고 경주 기록을 반환한다(case: 우승자 1명)") {
                val cars = listOf(
                    Car("1", PreparedDriver(listOf(0, 1, 4))),
                    Car("2", PreparedDriver(listOf(0, 4, 5))),
                    Car("3", PreparedDriver(listOf(9, 6, 7))),
                )
                val race = Race(cars, numberOfRaces)
                val records = race.proceed()
                records.last().carStates shouldContainInOrder cars.map { it.captureState() }
                race.selectWinner() shouldContainInOrder listOf("3")
            }

            it("경주를 진행하고 경주 기록을 반환한다(case: 우승자 여러 명)") {
                val cars = listOf(
                    Car("1", PreparedDriver(listOf(0, 1, 4))),
                    Car("2", PreparedDriver(listOf(7, 4, 5))),
                    Car("3", PreparedDriver(listOf(9, 6, 7))),
                )
                val race = Race(cars, numberOfRaces)
                val records = race.proceed()
                records.last().carStates shouldContainInOrder cars.map { it.captureState() }
                race.selectWinner() shouldContainInOrder listOf("2", "3")
            }
        }
    }
})
