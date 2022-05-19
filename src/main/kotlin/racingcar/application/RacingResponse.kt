package racingcar.application

import racingcar.domain.Cars
import racingcar.domain.Winner

class RacingResponse(val allResult: List<Cars>)

class WinnerResponse(val winner: Winner)
