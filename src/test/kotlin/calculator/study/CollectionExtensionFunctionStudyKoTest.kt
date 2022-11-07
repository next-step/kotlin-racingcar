package calculator.study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

/**
 * Collection 확장함수 기능을 학습하는 테스트
 */
internal class CollectionExtensionFunctionStudyKoTest : StringSpec({

    "chunk - size 와 step 이 동일할 때 원소가 겹치지 않는지" {
        val list = listOf(1, 2, 3, 4, 5)
        list.chunked(size = 2) { chunk: List<Int> ->
            val first = chunk.first()

            /**
             * 마지막 chunk 에서 chunk.first()와 chunk.last()가 동일한 값이 나옴.
             * chunk.size 가 기준 size 보다 작을 때, 남은 원소를 특수 케이스 패턴으로 처리 필요
             */
            val last = if (chunk.size == 2) chunk.last() else 6
            first shouldNotBe last
        }
    }

    "window - size 와 step 이 동일할 때 원소가 겹치는지" {
        val list = listOf(1, 2, 3, 4, 5)
        var temp = 1
        list.windowed(size = 2, step = 1, partialWindows = true) { window: List<Int> ->
            val first = window.first()
            first shouldBe temp

            val last = if (window.size == 2) window.last() else 6
            first shouldNotBe last

            temp = last
        }
    }
})
