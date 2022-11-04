package step2.interfaces.parser.implement

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat
import step2.application.parser.ParsingProcessor
import step2.application.parser.implement.SequentialParsingProcessor

internal class SequentialParsingProcessorKoTest : StringSpec({

    val parsingProcessor: ParsingProcessor = SequentialParsingProcessor()

    "이항 연산자를 입력 모델로 변환한다" {
        listOf(
            "1 + 1",
            "2 * 5",
            "3 - 4"
        ).forEach {
            val inputOperationCommandList = parsingProcessor.proceed(it)
            assertThat(inputOperationCommandList.size).isEqualTo(2)
        }
    }

    "연산자에 에러가 있으면 IllegalArgumentException 발생시킨다" {
        listOf(
            "1 ! 1",
            "2 _ 5",
            "0 1 4"
        ).forEach {
            shouldThrow<IllegalArgumentException> {
                parsingProcessor.proceed(it)
            }
        }
    }

    "숫자에 에러가 있으면 NumberFormatException 발생시킨다" {
        listOf(
            "( + 1",
            "2 - !",
            ":0 * 4"
        ).forEach {
            shouldThrow<NumberFormatException> {
                parsingProcessor.proceed(it)
            }
        }
    }

    "파싱된 값이 홀수가 아니면 오류가 발생한다" {
        listOf(
            "0 +",
            "2 - 1 + ",
            "5 - 4 + 1 /"
        ).forEach {
            shouldThrow<IllegalStateException> {
                parsingProcessor.proceed(it)
            }
        }
    }
})
