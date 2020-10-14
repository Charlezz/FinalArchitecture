# 찰스의 안드로이드 애플리케이션
## (구)Final Architecture
이 저장소는 찰스의 안드로이드 블로그를 안드로이드 버전으로 구현하였으며, 여러가지 기술과 디자인 패턴을 적용하는 예제를 보여줍니다. 모던 아키텍처를 지향하고, 알파 버전의 라이브러리를 포함하여 구글의 최신 라이브러리를 적용하여 작성되었습니다. 

구글의 최신 안드로이드 의존성 주입 라이브러리인 Hilt를 사용하는 것으로 코드를 간결화하고 쉬운 앱 스케일링을 보여줍니다. 또한 MVVM 패턴적용으로 쉬운 테스트 및 유지보수가 가능합니다.

[다운로드](https://play.google.com/store/apps/details?id=com.charlezz.android)

### 구현을 위해 사용한 기술들
이 저장소에서 사용된 기술은 찰스의 안드로이드 블로그에서 확인 하실 수 있으며, 링크 주소는 아래에서 확인 가능합니다.

- [Hilt](https://www.charlezz.com/?p=44416) : Dagger 기반의 단일 컴포넌트 지향 의존성 주입 라이브러리
- [Dagger2](https://www.charlezz.com/?p=428) : 객체의 생성을 담당하며 Activity나 Fragment의 생명주기에 맞게 인스턴스를 주입하고 관리한다.
- [Paging3](https://charlezz.com) : 포스팅 예정
- [DataBinding](https://developer.android.com/topic/libraries/data-binding/?hl=ko) : UI요소들과 Observable한 데이터의 바인딩을 도와주는 라이브러리
- [Lifecycles](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle) :  액티비티와 프레그먼트의 생명주기를 관리
- [LiveData](http://www.charlezz.com/?p=363) : 데이터의 변경을 감지 할 수 있으며, View에게 변경 이벤트 전달.
- [Room](http://www.charlezz.com/?p=368) : SQLite를 좀 더 편리하고, 유연하게 사용가능하게 한다.
- [ViewModel](http://www.charlezz.com/?p=365) : UIController의 생명주기를 알고있으며, 뷰에게 제공할 데이터를 관리한다.


