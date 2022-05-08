# kotlin-racingcar

## step1 기능 요구사항 정리
- [x] 입력한 문자열로 사칙연산을 수행할 수 있는 기능 구현하기
  - [x] 입력값이 null 이거나 빈 공백 문자 인 경우 IllegalArgumentException
  - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException
    - 연산자 확인 기능 추가
  - [x] 공백 문자열을 빈 공백 문자로 처리
    - 빈 공백 문자 삭제 기능 추가
    - space, tab, 줄 나눔 공백 삭제 기능 추가 
    
- [x] 문자열 계산은 사칙 연산 순서가 아닌, 입력 순서대로 작동하도록 하기