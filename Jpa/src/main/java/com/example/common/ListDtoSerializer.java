package com.example.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.List;

public class ListDtoSerializer<T> extends StdSerializer<ListDto<T>> {

    public ListDtoSerializer() {
        super(ListDto.class, false);
    }

    @Override
    public void serialize(ListDto<T> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        // 自定义序列化逻辑
        gen.writeObjectField("list", value.getList());
        gen.writeObjectField("pagination", value.getPagination());
        gen.writeEndObject();
    }
}
