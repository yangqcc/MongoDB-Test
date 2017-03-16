package com.yqc.query;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Created by yangqc on 2017/3/16.
 */
@ReadingConverter
public class PersonConverter implements Converter<Document, LimitPerson> {

    @Override
    public LimitPerson convert(Document document) {
        LimitPerson limitPerson = new LimitPerson();
        limitPerson.setName(document.getString("name"));
        return limitPerson;
    }

}
