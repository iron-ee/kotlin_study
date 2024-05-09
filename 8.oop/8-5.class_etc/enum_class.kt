package main.kotlin.oop.class_etc

// 추가적인 클래스를 상속받을 수 없다.
// 인터페이스는 구현할 수 있으며, 각 코드가 싱글톤
enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US"),
    CHINA("CN"),
    ;
}

// 컴파일러가 country 의 모든 타입을 알고있어서 다른 타입에 대한 로직(else)을 작성하지 않아도 된다.
// 그리고 enum 에 변화가 있으면 친절히 알려준다.
fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
        Country.CHINA -> TODO()
    }
}


/*
kotlin 의 Enum Class 는 java 와 동일하지만, when 과 함께 사용함으로써 더 큰 장점을 가짐.
 */