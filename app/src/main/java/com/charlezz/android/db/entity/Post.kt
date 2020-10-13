package com.charlezz.android.db.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
        @PrimaryKey val id: Long,
        val date: String,
        val link: String,
        val title: String,
        val content: String,
        val excerpt: String,
        val categories: List<Int>,
        val author: Int
)

    : Parcelable {
    constructor(source: Parcel) : this(
            source.readLong(),
            source.readString()?:"",
            source.readString()?:"",
            source.readString()?:"",
            source.readString()?:"",
            source.readString()?:"",
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(date)
        writeString(link)
        writeString(title)
        writeString(content)
        writeString(excerpt)
        writeList(categories)
        writeInt(author)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {
            override fun createFromParcel(source: Parcel): Post = Post(source)
            override fun newArray(size: Int): Array<Post?> = arrayOfNulls(size)
        }
    }
}

/**
{
    "id": 44223,
    "date": "2020-06-11T20:36:29",
    "date_gmt": "2020-06-11T11:36:29",
    "guid":
        {
        "rendered": "https://www.charlezz.com/?p=44223"
        },
    "modified": "2020-06-12T11:47:02",
    "modified_gmt": "2020-06-12T02:47:02",
    "slug": "%ec%bd%94%ed%8b%80%eb%a6%b0%ec%97%90%ec%84%9c-annotation-processor%eb%a5%bc-%eb%94%94%eb%b2%84%ea%b9%85-%ed%95%98%eb%8a%94-%eb%b0%a9%eb%b2%95",
    "status": "publish",
    "type": "post",
    "link": "https://www.charlezz.com/?p=44223",
    "title": {
    "rendered": "코틀린에서 Annotation Processor를 디버깅 하는 방법"
    },
    "content": {
        "rendered": "<h1>코틀린에서 Annotation Processor를 디버깅 하는 방법</h1>\n<p>https://medium.com/@cafonsomota/debug-annotation-processor-in-kotlin-6eb462e965f8</p>\n<p>아래에 나올 내용은 위 링크의 내용을 번역하고, 추가적인 내용을 덧붙인 글입니다.</p>\n<hr />\n<p><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_WFVqUbNPPqaMbWR_cz4qPA.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_WFVqUbNPPqaMbWR_cz4qPA.png\" alt=\"\" width=\"1000\" height=\"400\" class=\"aligncenter wp-image-44224 size-full\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_WFVqUbNPPqaMbWR_cz4qPA.png 1000w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_WFVqUbNPPqaMbWR_cz4qPA-300x120.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_WFVqUbNPPqaMbWR_cz4qPA-768x307.png 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></a></p>\n<p>코틀린 언어를 사용하면서 애노테이션 프로세서 다루는 경우 어떻게 디버깅을 할 수 있는지 알아봅시다.</p>\n<h2>로그 출력하기</h2>\n<p>어노테이션 프로세서가 컴파일 타임에 작업을 수행하는 동안 로그를 출력하기기 위해서는 ProcessingEnvironment.getMessager().printMessage(&#8230;)를 호출 해야 한다. ProcessingEnvironment 객체는 AbstractProcessor 클래스에 정의되어 있으므로 AbstractProcessor 클래스를 확장하는 클래스를 만드는 경우 이 객체에 쉽게 접근 할 수 있다.</p>\n<pre class=\"lang: decode:true \">class GenerateProcessor : AbstractProcessor() {\r\n\r\n  override fun process(type: MutableSet&lt;out TypeElement&gt;?, \r\n                       roundEnv: RoundEnvironment?): Boolean {\r\n    processingEnv.messager.printMessage(WARNING, \"Processing\")\r\n    ...</pre>\n<p>이 메소드는 몇가지 인자를 취하지만, 일반적으로 두가지만 사용한다.</p>\n<pre class=\"lang: decode:true \">void printMessage(Diagnostic.Kind kind, CharSequence charSequence);</pre>\n<p>Kind는 로그 메시지 타입으로, 다음과 같다. (나열된 순서가 위험도 높은순)</p>\n<ul>\n<li><strong>ERROR</strong><br />\n뭔가 누락되었거나 유효하지 않을 때 사용한다. 만약 이 타입이 정의 되어있다면 컴파일 과정은 취소되고, 콘솔 로그에서 에러를 보게 된다.</p>\n</li>\n<li><strong>WARNING</strong><br />\n뭔가 완전히 잘못되지는 않았으나, 컴파일을 중단하기에 충분한 상활 일 때 사용한다.</p>\n</li>\n<li><strong>MANDATORY_WARNING<br />\n</strong>warning과 비슷하지만 도구 사양에 따라 다르다. 예를 들면 자바 언어에서 특정 unchecked 동작이나 deprecated 된 메소드 사양에 대하여 경고를 띄울 수 있다.</p>\n</li>\n<li><strong>NOTE</strong><br />\n유용한 메시지를 출력한다. 예를들면 작업의 시작 또는 끝을 알릴 때 사용할 수 있다.</p>\n</li>\n<li><strong>OTHER</strong><br />\n위에 나열된 어떤 카테고리도 사용할 수 없을 때 사용할 수 있다.</li>\n</ul>\n<h2>디버깅 하기</h2>\n<p>스마트폰 또는 에뮬레이터에서 실행되는 앱에 디버거를 연결하는 것과 비슷한 방법으로 컴파일 프로세스에도 동일한 작업을 수행할 수 있다. </p>\n<p> 1.<em>리모트(Remote) 디버거</em>를 먼저 하나 만들어야 한다. 그리고 이를 이용해서 나중에 Annotation Processor 코드를 디버깅할 수 있다.</p>\n<p>2. 리모트 디버거를 만들기 위해 Edit Configuration을 클릭하여 Run/Debug Configuration 화면으로 진입하자</p>\n<p>3. (&#8220;+&#8221;) 버튼을 눌러서 Remote를 선택한다.</p>\n<p>4. Remote 디버거의 이름을 Debugger 또는 원하는 이름으로 짓자. 모든 작업이 끝나면 다음과 같은 화면을 볼 수 있다.</p>\n<p><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_pcmMQoK2xpiiuVQptPErMw.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_pcmMQoK2xpiiuVQptPErMw-1024x648.png\" alt=\"\" width=\"750\" height=\"475\" class=\"aligncenter size-large wp-image-44225\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_pcmMQoK2xpiiuVQptPErMw-1024x648.png 1024w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_pcmMQoK2xpiiuVQptPErMw-300x190.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_pcmMQoK2xpiiuVQptPErMw-768x486.png 768w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_pcmMQoK2xpiiuVQptPErMw.png 1068w\" sizes=\"(max-width: 750px) 100vw, 750px\" /></a></p>\n<p>5. <em>gradle.properties</em> 파일에 다음과 같은 내용을 추가하자</p>\n<pre class=\"lang: decode:true \">kapt.use.worker.api=true</pre>\n<p>이것을 추가하지 않으면 <strong>브레이크포인트(Breakpoint)에서 멈추질 않는다</strong>.</p>\n<p>6. 이제 모든것이 준비되었으니 <em>Terminal</em> 에서 컴파일을 시작하자. </p>\n<pre class=\"lang: decode:true\">./gradlew --no-daemon -Dorg.gradle.debug=true -Dkotlin.daemon.jvm.options=\"-Xdebug,-Xrunjdwp:transport=dt_socket\\,address=5005\\,server=y\\,suspend=n\" :clean assemble</pre>\n<p>7. 커맨드를 입력하고 입력하면 debugger가 붙을 때까지 프로세스가 기다린다.</p>\n<p><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_JAPD8TFkg_ryDurTpndKOA.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_JAPD8TFkg_ryDurTpndKOA.png\" alt=\"\" width=\"969\" height=\"371\" class=\"aligncenter size-full wp-image-44226\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_JAPD8TFkg_ryDurTpndKOA.png 969w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_JAPD8TFkg_ryDurTpndKOA-300x115.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_JAPD8TFkg_ryDurTpndKOA-768x294.png 768w\" sizes=\"(max-width: 969px) 100vw, 969px\" /></a></p>\n<p>8. 아까 만들어 두었던 Remote &#8220;<em>Debugger</em>&#8220;를 선택하고 <em>debug</em> 버튼을 클릭하자.</p>\n<p><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_W-n-mG1jnfLz2ybaVyFwfQ.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/06/1_W-n-mG1jnfLz2ybaVyFwfQ-1024x25.png\" alt=\"\" width=\"750\" height=\"18\" class=\"aligncenter size-large wp-image-44227\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_W-n-mG1jnfLz2ybaVyFwfQ-1024x25.png 1024w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_W-n-mG1jnfLz2ybaVyFwfQ-300x7.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_W-n-mG1jnfLz2ybaVyFwfQ-768x19.png 768w, https://charlezz.com/wordpress/wp-content/uploads/2020/06/1_W-n-mG1jnfLz2ybaVyFwfQ.png 1077w\" sizes=\"(max-width: 750px) 100vw, 750px\" /></a></p>\n<p>9. Daemon이 디버거(Debugger)가 붙은것을 감지하고 나면, 컴파일 작업이 재개되고 지정된 브레이크포인트에서 멈추게 될 것이다.</p>\n<h3>gardle 명령어 하나씩 살펴보기</h3>\n<h4>Gradle Daemon</h4>\n<pre class=\"lang: decode:true \">-Dorg.gradle.debug=true</pre>\n<p>그레이들 프로세스가 시작되면 리모트 디버깅이 활성화됨과 동시에 빌드를 수행하게 된다. 5005번 포트를 기본값으로 사용하여 수신 대기하며 이는 다음의 내용을 호출하는것과 동등하다.</p>\n<pre class=\"lang: decode:true\">-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005</pre>\n<p>만약 <em>suspend</em> 속성이 true인것을 확인할 수 있는데 이는 디버거가 붙을 때까지 가상머신을 유예시킨다는 의미다.</p>\n<h4>Kotlin Demon</h4>\n<pre class=\"lang: decode:true \">-Dkotlin.daemon.jvm.options=\"-Xdebug,-Xrunjdwp:transport=dt_socket\\,address=5005\\,server=y\\,suspend=n\"</pre>\n<p>코틀린은 5005포트에서 디버거를 수신 대기하는 데몬 프로세스를 시작한다.</p>\n<ul>\n<li><strong class=\"jd lf\">transport</strong><br />\n디버거를 앱에 연결하는데 사용되는 transport의 이름을 설정한다. 필수값이며 기본값은 none이다.</p>\n</li>\n<li><strong>address<br />\n</strong>연결을 위한 transport 주소다. 만약 디버거의 <em>server</em> 옵션이 <em>n</em>으로 설정되어 있다면 디버거는 해당 address로 연결을 시도하고, y로 설정되었다면 해당 포트에서 연결을 수신대기한다.</p>\n</li>\n<li><strong>server<br />\n</strong>y면 디버거가 연결될 수 있도록 수신 대기한다. 그렇지 않으면, 지정된 address로 디버거가 연결을 시도한다. 설정하지 않은 경우 기본값은 n이다.</p>\n</li>\n<li><strong>suspend</strong><br />\n<span><em>SUSPEND_ALL</em> 인 경우 <em>VMStartEvent</em>에 사용되는 정책을 정의한다. 그렇지 않으면 <em>SUSPEND_NONE</em> 이다. 설정하지 않은 경우 기본값은 y다.</span></li>\n</ul>\n<p>마지막에 적힌 명령어는 현재 프로젝트를 클린 한 뒤 컴파일 할 수 있도록 한다.</p>\n<pre class=\"lang: decode:true \">:clean assemble</pre>\n<p>만약에 특정 모듈만 클린 후 컴파일 하고  싶다면 다음과 같이 바꾸어 사용할 수 있다.</p>\n<pre class=\"lang: decode:true \">:모듈명:clean :모듈명:assemble\r\n</pre>\n<h2>Troubleshooting</h2>\n<h3>jps</h3>\n<p><em>jps(Java Virtual Machine Process Status Tool) </em>라는 명령어 가 있다. </p>\n<pre class=\"lang: decode:true\">$ jps</pre>\n<p>현재 JVM에서 실행되고 있는 모든 프로세스 목록을 나타낸다. 디버거를 붙일 때 Connection Refused( 연결 거부 ) 에러가 자꾸 발생한다면 jps명령어를 통해 5005번 포트를 사용하는 활성화 된 데몬이 남아 있는지 확인할 수 있다.</p>\n<pre class=\"lang: decode:true\">$ jps\r\n5541 GradleDaemon\r\n294 \r\n5671 Jps</pre>\n<p>만약 남아있다면 <em>./gradlew &#8211;stop</em> 또는 <em>kill(프로세스 아이디)</em> 를 호출하여 강제로 종료 시킬 수 있다.<br />\n위의 경우 프로세스 아이디(pid)가 5541이므로 <em>kill(5541)</em>을 호출하면 종료된다.</p>\n<h3>com.sun.tools.javac.code.* 클래스가 존재 하지 않을 때</h3>\n<p>com.sun.tools.javac.code 패키지에 있는 클래스를 사용하는 경우 컴파일 타임에 해당 클래스가 존재하지 않는다는 에러가 발생할 수 있다. 어노테이션 프로세서 모듈에 다음과 같은 내용을 추가하자</p>\n<pre class=\"lang:null decode:true lang:\">dependencies {\r\n    implementation(files(\"${System.getProperty(\"java.home\")}/../lib/tools.jar\"))\r\n}</pre>\n<h3>tools.jar가 없다고 나올 때</h3>\n<p>tools.jar가 없다고 컴파일 에러가 발생하는 경우가 있다. 여러 버전의 JDK를 사용하는 경우 발생 할 수 있다. 왜냐하면 tools.jar는 Java9에서 삭제된 라이브러리인데 Android Studio는 Java8을 사용하며, 터미널 환경변수는 JDK9 이상을 사용하는 경우에 해당 에러를 볼 수 있다. 이 경우 JDK경로를 JDK8로 설정하도록 하자.</p>\n<pre class=\"lang: decode:true \"># OSX .bash_profile\r\nexport JAVA_HOME=$(/usr/libexec/java_home -v 1.8)</pre>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n",
        "protected": false
        },
    "excerpt": {
    "rendered": "<p>코틀린에서 Annotation Processor를 디버깅 하는 방법 https://medium.com/@cafonsomota/debug-annotation-processor-in-kotlin-6eb462e965f8 아래에 나올 내용은 위 링크의 내용을 번역하고, 추가적인 내용을 덧붙인 글입니다. 코틀린 언어를 사용하면서 애노테이션 프로세서 다루는 경우 어떻게 디버깅을 할 수 있는지 알아봅시다. 로그 출력하기 어노테이션 프로세서가 컴파일 타임에 작업을 수행하는 동안 로그를 출력하기기 위해서는 ProcessingEnvironment.getMessager().printMessage(&#8230;)를 호출 해야 한다. ProcessingEnvironment 객체는 AbstractProcessor [&hellip;]</p>\n",
    "protected": false
    },
    "author": 1,
    "featured_media": 0,
    "comment_status": "open",
    "ping_status": "open",
    "sticky": false,
    "template": "",
    "format": "standard",
    "meta": [],
    "categories": [2,5],
    "tags": [],
    "_links": {
    "self": [
    {
    "href": "https://www.charlezz.com/index.php?rest_route=/wp/v2/posts/44223"
    }
    ],
    "collection": [
    {
    "href": "https://www.charlezz.com/index.php?rest_route=/wp/v2/posts"
    }
    ],
    "about": [
    {
    "href": "https://www.charlezz.com/index.php?rest_route=/wp/v2/types/post"
    }
    ],
    "author": [
    {
    "embeddable": true,
    "href": "https://www.charlezz.com/index.php?rest_route=/wp/v2/users/1"
    }
    ],
    "replies": [
    {
    "embeddable": true,
    "href": "https://www.charlezz.com/index.php?rest_route=%2Fwp%2Fv2%2Fcomments&post=44223"
    }
    ],
    "version-history": [
    {
    "count": 2,
    "href": "https://www.charlezz.com/index.php?rest_route=/wp/v2/posts/44223/revisions"
    }
    ],
    "predecessor-version": [
    {
    "id": 44266,
    "href": "https://www.charlezz.com/index.php?rest_route=/wp/v2/posts/44223/revisions/44266"
    }
    ],
    "wp:attachment": [
    {
    "href": "https://www.charlezz.com/index.php?rest_route=%2Fwp%2Fv2%2Fmedia&parent=44223"
    }
    ],
    "wp:term": [
    {
    "taxonomy": "category",
    "embeddable": true,
    "href": "https://www.charlezz.com/index.php?rest_route=%2Fwp%2Fv2%2Fcategories&post=44223"
    },
    {
    "taxonomy": "post_tag",
    "embeddable": true,
    "href": "https://www.charlezz.com/index.php?rest_route=%2Fwp%2Fv2%2Ftags&post=44223"
    }
    ],
    "curies":
    [
    {
    "name": "wp",
    "href": "https://api.w.org/{rel}",
    "templated": true
    }
    ]
    }
}

 */
