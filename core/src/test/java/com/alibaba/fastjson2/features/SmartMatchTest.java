package com.alibaba.fastjson2.features;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.TestUtils;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartMatchTest {
    @Test
    public void test() {
        String str = "{\"user_id\":101,\"user_id_\":102}";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        assertEquals(101, JSON.parseObject(str, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.UTF_8, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.US_ASCII, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);

        assertEquals(101, TestUtils.createJSONReaderStr(str, JSONReader.Feature.SupportSmartMatch).read(Bean.class).userId);
    }

    @Test
    public void test1() {
        String str = "{\"user_id\":101,\"user__id\":102}";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        assertEquals(101, JSON.parseObject(str, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.UTF_8, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.US_ASCII, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);

        assertEquals(101, TestUtils.createJSONReaderStr(str, JSONReader.Feature.SupportSmartMatch).read(Bean.class).userId);
    }

    @Test
    public void test2() {
        String str = "{\"user-id\":101,\"user-id-\":102}";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        assertEquals(101, JSON.parseObject(str, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.UTF_8, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.US_ASCII, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);

        assertEquals(101, TestUtils.createJSONReaderStr(str, JSONReader.Feature.SupportSmartMatch).read(Bean.class).userId);
    }

    @Test
    public void test3() {
        String str = "{\"user-id\":101,\"user--id\":102}";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        assertEquals(101, JSON.parseObject(str, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.UTF_8, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);
        assertEquals(101, JSON.parseObject(bytes, 0, bytes.length, StandardCharsets.US_ASCII, Bean.class, JSONReader.Feature.SupportSmartMatch).userId);

        assertEquals(101, TestUtils.createJSONReaderStr(str, JSONReader.Feature.SupportSmartMatch).read(Bean.class).userId);
    }

    public static class Bean {
        public int userId;
    }
}
