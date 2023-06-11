package racing.domain.strategy

import racing.domain.DirectionType

fun interface Navigator {
    fun navigate(): DirectionType
}
