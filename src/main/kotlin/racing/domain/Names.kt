package racing.domain

import racing.domain.vo.Name
import racing.exception.CarsNameException

class Names(val names: List<Name>) {
    init {
        if (names.isEmpty()) throw CarsNameException(INVALID_CAR_NAMES)
    }

    companion object {
        private const val INVALID_CAR_NAMES = "자동차 이름은 1개 이상이여야 합니다."
    }
}
