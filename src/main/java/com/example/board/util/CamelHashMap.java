package com.example.board.util;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.support.JdbcUtils;

public class CamelHashMap extends ListOrderedMap {
    public Object put(Object key, Object value) {
        // StringUtils.lowerCase 로 key를 소문자로 변경 (USER_NAME => user_name)
        // JdbcUtils.convertUnderscoreNameToPropertyName 로 key를 camelCase로 변경 (user_name => userName)
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(StringUtils.lowerCase((String) key)), value);
    }
}
