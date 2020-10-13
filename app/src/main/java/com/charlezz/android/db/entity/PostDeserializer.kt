package com.charlezz.android.db.entity

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * @author Charlezz
 */
class PostDeserializer : JsonDeserializer<Post> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): Post {

        val jsonObject = json.asJsonObject
        return Post(
                jsonObject.get("id").asLong,
                jsonObject.get("date").asString,
                jsonObject.get("link").asString,
                jsonObject.get("title").asJsonObject.get("rendered").asString,
                jsonObject.get("content").asJsonObject.get("rendered").asString,
                jsonObject.get("excerpt").asJsonObject.get("rendered").asString,
                jsonObject.get("categories").asJsonArray.map { it.asInt },
                jsonObject.get("author").asInt
        )
    }

}