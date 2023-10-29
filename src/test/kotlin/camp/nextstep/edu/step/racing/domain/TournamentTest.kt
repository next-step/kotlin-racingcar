package camp.nextstep.edu.step.racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("대회는")
class TournamentTest : BehaviorSpec({

    Given("경기 이름과 트랙정보, 참여하는 자동차들과 시도할 횟수가 주어지고") {
        val tournamentName = "캠프 페스티벌"
        val racingTrack = RacingTrack.of(trackName = "경기도 하남 레이싱트랙")
        val hyundaiCar = Car(carName = "현대모비스 레이싱카")
        val kiaCar = Car(carName = "기아자동차 레이싱카")
        val cars = listOf(hyundaiCar, kiaCar)

        When("대회를 생성하면") {
            val tournament = Tournament.of(
                tournamentName = tournamentName,
                track = racingTrack,
                tournamentInformation = Tournament.TournamentInformation(cars = cars, tryCount = 5)
            )

            Then("주어진 정보의 대회가 생성된다") {
                tournament.tournamentName shouldBe "캠프 페스티벌"
                tournament.track.trackName shouldBe "경기도 하남 레이싱트랙"
                tournament.tournamentInformation.cars shouldBe listOf(
                    Car(carName = "현대모비스 레이싱카"),
                    Car(carName = "기아자동차 레이싱카")
                )
                tournament.tournamentInformation.tryCount shouldBe 5

            }
        }
    }

    Given("만약 대회 일부 정보가 없이") {
        val racingTrack = RacingTrack.of(trackName = "경기도 하남 레이싱트랙")
        val hyundaiCar = Car(carName = "현대모비스 레이싱카")
        val kiaCar = Car(carName = "기아자동차 레이싱카")
        val cars = listOf(hyundaiCar, kiaCar)

        When("대회를 생성하면") {
            val notHaveTournamentName = shouldThrow<IllegalArgumentException> {
                Tournament.of(
                    tournamentName = "",
                    track = racingTrack,
                    tournamentInformation = Tournament.TournamentInformation(cars = cars, tryCount = 5)
                )
            }

            val notHaveTrack = shouldThrow<IllegalArgumentException> {
                Tournament.of(
                    tournamentName = "캠프 페스티벌",
                    track = RacingTrack.of(trackName = ""),
                    tournamentInformation = Tournament.TournamentInformation(cars = cars, tryCount = 5)
                )
            }

            val notHaveCars = shouldThrow<IllegalArgumentException> {
                Tournament.of(
                    tournamentName = "캠프 페스티벌",
                    track = racingTrack,
                    tournamentInformation = Tournament.TournamentInformation(cars = emptyList(), tryCount = 5)
                )
            }

            Then("예외가 발생한다") {
                notHaveTournamentName.message shouldBe "대회 이름이 비어있습니다."
                notHaveTrack.message shouldBe "경주장의 이름이 비어있습니다."
                notHaveCars.message shouldBe "참여하는 자동차가 없습니다."
            }
        }
    }

})
