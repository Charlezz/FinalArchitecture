package com.charlezz.android

import com.charlezz.android.db.entity.Post
import com.charlezz.android.db.entity.PostDeserializer
import com.charlezz.android.network.PostService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HtmlPaserTest {

    val content = "<p><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-screenshot.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-screenshot.png\" alt=\"\" width=\"2272\" height=\"1852\" class=\"aligncenter size-full wp-image-44529\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-screenshot.png 2272w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-screenshot-300x245.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-screenshot-768x626.png 768w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-screenshot-1024x835.png 1024w\" sizes=\"(max-width: 2272px) 100vw, 2272px\" /></a></p>\n" +
            "<p><a href=\"https://droidknights.github.io/2020/\">https://droidknights.github.io/2020/</a></p>\n" +
            "<p>코로나로 인해 올해 드로이드 나이츠 행사는 <a href=\"https://www.youtube.com/c/DroidKnights\"><strong>온라인 스트리밍</strong></a>으로 진행됩니다.</p>\n" +
            "<p>저는 2주차에  &#8216;<strong>Hilt와 함께하는 안드로이드 의존성 주입</strong>&#8216; 이라는 주제로 세션을 맡게되었습니다.<br />\n" +
            "많은 시청 부탁드립니다.<br />\n" +
            "<a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-1.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-1.png\" alt=\"\" width=\"2076\" height=\"1176\" class=\"aligncenter size-full wp-image-44531\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-1.png 2076w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-1-300x170.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-1-768x435.png 768w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-1-1024x580.png 1024w\" sizes=\"(max-width: 2076px) 100vw, 2076px\" /></a><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-2.png\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-2.png\" alt=\"\" width=\"1620\" height=\"690\" class=\"aligncenter size-full wp-image-44532\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-2.png 1620w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-2-300x128.png 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-2-768x327.png 768w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-screenshot-2-1024x436.png 1024w\" sizes=\"(max-width: 1620px) 100vw, 1620px\" /></a><strong>세션 공개 후 <a href=\"https://www.youtube.com/channel/UCjeUnwS8mHhsl600-nFJKmw\">유투브 영상</a> 및 발표자료를 이 페이지에 업로드 할 예정입니다. 감사합니다.</strong></p>\n" +
            "<p><a href=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-youtube-logo-dark.jpg\"><img src=\"https://www.charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-youtube-logo-dark.jpg\" alt=\"\" width=\"1200\" height=\"600\" class=\"aligncenter size-full wp-image-44533\" srcset=\"https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-youtube-logo-dark.jpg 1200w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-youtube-logo-dark-300x150.jpg 300w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-youtube-logo-dark-768x384.jpg 768w, https://charlezz.com/wordpress/wp-content/uploads/2020/09/www.charlezz.com-2020-hilt-youtube-logo-dark-1024x512.jpg 1024w\" sizes=\"(max-width: 1200px) 100vw, 1200px\" /></a></p>"

    lateinit var retrofit: Retrofit

    @Before
    fun setup() {
        val gson = GsonBuilder()
        gson.registerTypeAdapter(Post::class.java, PostDeserializer())

        retrofit = Retrofit.Builder()
                .baseUrl("https://charlezz.com")
                .addConverterFactory(GsonConverterFactory.create(gson.create()))
                .build()
    }

    @Test
    fun getPosts() {

        runBlocking {
            println(retrofit.create(PostService::class.java).getPosts()[1].content)
        }


//        val document = Jsoup.parse(content)
//        for(element in document.body().children()){
//            println("#$element")
//            element.nextElementSibling()
//        }


    }

}