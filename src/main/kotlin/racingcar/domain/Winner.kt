package racingcar.domain

import racingcar.domain.vo.Name

class Winner(private val winner: Car) {
    fun name(): Name = winner.name
}
