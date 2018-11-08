package com.dieson.green.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Set;


public class AssertUtil {
    /**
     * 数据校验
     *
     * @param expect
     * @param actual
     * @return
     */
    public static String assertData(Object expect, Object actual) {
        try {
            if (!expect.getClass().equals(JSONObject.class) && !expect.getClass().equals(Arrays.class)) {
                assert expect.equals(actual);
            } else if (expect.getClass().equals(JSONObject.class)) {
                assertJSON((JSONObject) expect, (JSONObject) actual);
            } else if (expect.getClass().equals(Arrays.class)) {
                assertList(expect, actual);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "参数校验失败！";
        }
        return "参数校验成功";
    }

    /**
     * 校验list
     *
     * @param expect
     * @param actual
     */
    public static void assertList(Object expect, Object actual) throws NoSuchFieldException, IllegalAccessException {
        Object[] expectArray = (Object[]) expect;
        Object[] actualArray = (Object[]) actual;
        Arrays.sort(expectArray);
        Arrays.sort(actualArray);

        assert expectArray.length <= actualArray.length;

        for (int i = 0; i < expectArray.length; i++) {
            if (!expect.getClass().equals(JSONObject.class) && !expect.getClass().equals(Arrays.class)) {
                assert expectArray[i].equals(actualArray[i]);
            } else if (expect.getClass().equals(JSONObject.class)) {
                assertJSON((JSONObject) expectArray[i], (JSONObject) actualArray[i]);
            } else if (expect.getClass().equals(Arrays.class)) {
                assertList(expectArray[i], actualArray[i]);
            }
        }

    }

    /**
     * 校验JSON格式数据
     *
     * @param expect
     * @param actual
     */
    public static void assertJSON(JSONObject expect, JSONObject actual) throws NoSuchFieldException, IllegalAccessException {
        Set<String> keys = expect.keySet();
        for (Object key : keys) {
            Object expectValue = expect.get(key);
            Object actualValue = actual.get(key);

            if (expectValue == null) {
                assert actualValue == null;
            } else if (!expectValue.getClass().equals(JSONObject.class) && !actualValue.getClass().equals(Arrays.class)) {
                assert expectValue.equals(actualValue);
            } else if (expectValue.getClass().equals(JSONObject.class)) {
                assertJSON((JSONObject) expectValue, (JSONObject) actualValue);
            } else if (expectValue.getClass().equals(Arrays.class)) {
                assertList(expectValue, actualValue);
            }

        }
    }

}
