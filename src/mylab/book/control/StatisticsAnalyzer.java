package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.*;

public class StatisticsAnalyzer {

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        }
        return "기타";
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            sumMap.put(type, sumMap.getOrDefault(type, 0.0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgMap = new LinkedHashMap<>();
        for (String type : sumMap.keySet()) {
            avgMap.put(type, sumMap.get(type) / countMap.get(type));
        }
        return avgMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        int totalCount = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distMap = new LinkedHashMap<>();
        for (String type : countMap.keySet()) {
            distMap.put(type, ((double) countMap.get(type) / totalCount) * 100);
        }
        return distMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        if (publications == null || publications.length == 0) return 0.0;
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return ((double) count / publications.length) * 100;
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat priceFormat = new DecimalFormat("#,##0원");
        DecimalFormat percentFormat = new DecimalFormat("0.00%");

        System.out.println("===== 출판물 통계 분석 =====");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        String[] types = {"소설", "참고서", "잡지"};
        for (String t : types) {
            if (avgPrice.containsKey(t)) {
                System.out.println("   - " + t + ": " + priceFormat.format(Math.round(avgPrice.get(t))));
            }
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        for (String t : types) {
            if (dist.containsKey(t)) {
                System.out.println("   - " + t + ": " + percentFormat.format(dist.get(t) / 100.0));
            }
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + percentFormat.format(calculatePublicationRatioByYear(publications, "2007") / 100.0));
    }
}