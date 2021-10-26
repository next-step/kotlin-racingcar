package domain.step4.domain.racingcar

import global.strategy.split.SplitStrategy

data class Names private constructor(private val _names: List<Name>) {
    init {
        require(_names.isNotEmpty()) { EMPTY_MESSAGE }
    }

    val names: List<Name>
        get() {
            return _names.toList()
        }

    fun size(): Int = _names.size

    companion object {
        private const val EMPTY_MESSAGE = "비어있는 값은 들어올 수 없습니다."

        fun ofStringWithSplitStrategy(target: String, splitStrategy: SplitStrategy): Names =
            splitStrategy.split(target)
                .map { name -> Name(name) }
                .let { ofList(it) } // 없으면 빈 컬렉션 값을 사용할 수 있기 때문에 조심해야겠군요!!

        fun ofList(names: List<Name>): Names = Names(names.toList())
    }
}