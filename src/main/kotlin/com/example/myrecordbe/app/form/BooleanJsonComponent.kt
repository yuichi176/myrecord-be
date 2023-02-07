package com.example.myrecordbe.app.form

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import java.io.IOException
import java.lang.NumberFormatException

/**
 * ブール型カスタムシリアライザー・デシリアライザー
 * <p>0 ⇆ false, 1 ⇆ true</p>
 */
@JsonComponent
class BooleanJsonComponent {

    class Serializer : JsonSerializer<Boolean>() {
        @Throws(IOException::class)
        override fun serialize(value: Boolean, jgen: JsonGenerator, serializers: SerializerProvider) {
            jgen.writeNumber(if(value) 1 else 0)
        }
    }

    class Deserializer : JsonDeserializer<Boolean>() {
        @Throws(IOException::class, JsonProcessingException::class)
        override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): Boolean {
            return when(jsonParser.valueAsString) {
                "0" -> false
                "1" -> true
                else -> throw NumberFormatException()
            }
        }
    }
}
