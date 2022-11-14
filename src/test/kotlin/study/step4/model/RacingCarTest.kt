package study.step4.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.assertj.core.api.Assertions.assertThat

class RacingCarTest : StringSpec({

    "주어진 레이싱 경기에, 참가하는 자동차 수가 주어지면, 조회한 자동차 수도 같아야 한다" {
        listOf(
            listOf("1") to 1,
            listOf("1", "2", "3") to 3,
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9") to 9
        ).forAll { (carName, size) ->
            // given & when
            val racingGame = RacingGame(
                racingCarNames = carName,
                repeatNumber = 3,
                digitGenerator = RandomDigit()
            )

            // then
            assertThat(racingGame.getCars().size).isEqualTo(size)
        }
    }

    "주어진 레이싱 경기에 시도하는 횟수를 주고, 레이스를 진행하면, 참여한 자동차의 레이스횟수가 시도하는 횟수와 같다" {
        listOf(
            1,
            10,
            30
        ).forAll {
            // given
            val racingGame = RacingGame(
                racingCarNames = listOf("name"),
                repeatNumber = it,
                digitGenerator = RandomDigit()
            )

            // when
            racingGame.race()

            // then
            racingGame.getCars().forEach { car ->
                assertThat(car.getRacingTimes()).isEqualTo(it)
            }
        }
    }

    "주어진 레이싱 경기에, 주어진 숫자가 4 이상이면, Car 은 모두 시도 횟수만큼 전진한다" {
        listOf(
            4, 5, 6, 7, 8, 9
        ).forAll {
            // given
            val racingGame = RacingGame(
                racingCarNames = listOf("name"),
                repeatNumber = 3,
                digitGenerator = StaticDigit(it)
            )

            // when
            racingGame.race()

            // then
            racingGame.getCars().forEach { car ->
                assertThat(car.getLocation()).isEqualTo(3)
            }
        }
    }

    "주어진 레이싱 경기에, 주어진 숫자가 4 미만, Car 은 모두 멈춰 있는다" {
        listOf(
            0, 1, 2, 3
        ).forAll {
            // given
            val racingGame = RacingGame(
                racingCarNames = listOf("name"),
                repeatNumber = 3,
                digitGenerator = StaticDigit(it)
            )

            // when
            racingGame.race()

            // then
            racingGame.getCars().forEach { car ->
                assertThat(car.getLocation()).isEqualTo(0)
            }
        }
    }

    "레이싱 경과 경기후, 챔피언을 조회하면, 거리가 가장 먼 자동차가 반환된다" {
        // given
        val cars = mutableListOf(
            Car("name1", 10, 5),
            Car("name2", 11, 5),
            Car("name3", 8, 5)
        )

        // when
        val racingGame = RacingGame(
            racingCarNames = listOf("name"),
            repeatNumber = 3,
            digitGenerator = RandomDigit(),
            cars = cars
        )

        // then
        val champion = racingGame.getChampions().first()
        assertThat(champion.name).isEqualTo("name2")
        assertThat(champion.getLocation()).isEqualTo(11)
    }

    "레이싱 경과 경기후 챔피언이 중복인 경우, 챔피언을 조회하면, 거리가 가장 먼 자동차 모두가 반환된다" {
        // given
        val cars = mutableListOf(
            Car("name1", 10, 5),
            Car("name2", 11, 5),
            Car("name3", 8, 5),
            Car("name4", 11, 5),
        )

        // when
        val racingGame = RacingGame(
            racingCarNames = listOf("name"),
            repeatNumber = 3,
            digitGenerator = RandomDigit(),
            cars = cars
        )

        // then
        val champions = racingGame.getChampions()
        assertThat(champions.size).isEqualTo(2)
        champions.forEach {
            assertThat(it.getLocation()).isEqualTo(11)
        }
    }
})
