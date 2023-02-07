package com.example.myrecordbe.app.form

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.google.cloud.Timestamp
import org.springframework.boot.jackson.JsonComponent
import java.io.IOException
import java.text.SimpleDateFormat

@JsonComponent
class TimestampJsonComponent {
    class Serializer : JsonSerializer<Timestamp>() {
        @Throws(IOException::class)
        override fun serialize(value: Timestamp, jgen: JsonGenerator, serializers: SerializerProvider) {
            val df = SimpleDateFormat("yyyy-MM-dd")
            jgen.writeString(df.format(value.toDate()))
        }
    }
}