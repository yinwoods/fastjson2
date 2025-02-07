package com.alibaba.fastjson2.benchmark.wast;

import static com.alibaba.fastjson2.benchmark.JMH.BH;

public class LongTextParseCaseTest {
    public static void fastjson2_perf_test() {
        for (int i = 0; i < 10; i++) {
            fastjson2_perf();
        }
    }

    public static void fastjson2_perf() {
        LongTextParseCase benchmark = new LongTextParseCase();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; ++i) {
            benchmark.fastjson2(BH);
        }
        long millis = System.currentTimeMillis() - start;
        System.out.println("LongTextParseCase-fastjson2 : " + millis);

        // zulu8.62.0.19 : 1583 897 821
        // zulu11.52.13 :
        // zulu17.32.13 :
        // zulu18.28.13 :
        // zulu19.0.47 :
        // corretto-8 :
        // corretto-11 : 1228 806
        // corretto-17 :
        // corretto-18 :
        // oracle-jdk-17.0.4 : 802
        // oracle-jdk-18.0.2 : 802
    }

    public static void wastjson_perf_test() {
        for (int i = 0; i < 10; i++) {
            wastjson_perf();
        }
    }

    public static void wastjson_perf() {
        LongTextParseCase benchmark = new LongTextParseCase();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; ++i) {
            benchmark.wastjson(BH);
        }
        long millis = System.currentTimeMillis() - start;
        System.out.println("LongTextParseCase-wastjson : " + millis);

        // zulu8.62.0.19 : 789 1061
        // zulu11.52.13 :
        // zulu17.32.13 :
        // zulu18.28.13 :
        // zulu19.0.47 :
        // corretto-8 :
        // corretto-11 : 1070
        // corretto-17 :
        // corretto-18 :
        // oracle-jdk-17.0.4 : 1068
        // oracle-jdk-18.0.2 : 1062
    }

    public static void main(String[] args) throws Exception {
        fastjson2_perf_test();
//        jackson_perf_test();
//        wastjson_perf_test();
    }
}
