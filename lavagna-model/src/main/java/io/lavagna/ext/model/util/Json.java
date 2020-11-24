package io.lavagna.ext.model.util;

import com.google.gson.*;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.TimeZone;

public final class Json {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    public static final String SYSTEM_LABEL_ASSIGNED = "ASSIGNED";
    public static final String SYSTEM_LABEL_DUE_DATE = "DUE_DATE";
    public static final String SYSTEM_LABEL_MILESTONE = "MILESTONE";
    public static final String SYSTEM_LABEL_WATCHED_BY = "WATCHED_BY";


    private Json() {
    }

    public static class CustomDateSerializer implements JsonSerializer<Date> {
        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return date == null ? JsonNull.INSTANCE : new JsonPrimitive(formatDate(date));
        }
    }

    @SuppressWarnings("InvalidTimeZoneID")
    public static String formatDate(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT, TimeZone.getTimeZone("Z"));
    }

    public static final Gson GSON = new GsonBuilder()
        .serializeNulls()
        .setDateFormat(DATE_FORMAT)
        .registerTypeHierarchyAdapter(Date.class, new CustomDateSerializer())
        .create();
}
