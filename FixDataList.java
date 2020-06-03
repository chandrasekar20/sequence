package com.lumiin.mytalk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class FixDataList implements Serializable {


    ConcurrentSkipListSet<FixSequenceData> list = new ConcurrentSkipListSet<>();
    private ConcurrentHashMap<String, ConcurrentSkipListSet<FixSequenceData>> orderData = new ConcurrentHashMap<>();


    public ConcurrentSkipListSet<FixSequenceData> getList() {
        return list;
    }

    public void addSequence(FixSequenceData data){
        list.add(data);
    }

    public void inti(){
        //ConcurrentSkipListSet<FixSequenceData> stocksSet = new ConcurrentSkipListSet<>();
       // orderData.put("Stocks", stocksSet);
    }

    public ConcurrentHashMap<String, ConcurrentSkipListSet<FixSequenceData>> getFinancialMarketData() {
        return orderData;
    }

    public ConcurrentHashMap<String, ConcurrentSkipListSet<FixSequenceData>> getData() {
        return orderData;
    }

    public ConcurrentSkipListSet<FixSequenceData> getAllData(String code) {
        return getList();
    }

    public void addData(String code, FixSequenceData fixData) {
        if (orderData.get(code) != null) {
            orderData.get(code).add(fixData);
        }else {
            ConcurrentSkipListSet<FixSequenceData> list = new ConcurrentSkipListSet<>();
            list.add(fixData);
            orderData.put(code, list);
        }
    }

    public FixSequenceData getData(String code, char type) {
        if (orderData.get(code) != null) {
            ConcurrentSkipListSet<FixSequenceData> sequence = orderData.get(code);
            Iterator<FixSequenceData> iterator = sequence.iterator();
            while(iterator.hasNext()) {
                FixSequenceData market = iterator.next();
                if (market.getType() == '1') {
                    return market;
                }
                else if (market.getType() == '2') {
                    return market;
                }
            }
        }
        return null;
    }

    public  ConcurrentSkipListSet<FixSequenceData> getData(String code) {
        ConcurrentHashMap<String, ConcurrentSkipListSet<FixSequenceData>> result = getData();
        return result.get(code);
    }


    public FixSequenceData getMarket(String code) {
        if (orderData.get(code) != null) {
            ConcurrentSkipListSet<FixSequenceData> sequence = orderData.get(code);
            Iterator<FixSequenceData> iterator = sequence.iterator();
        }
        return null;
    }

    public int[] getNumbers(String code) {
        int numbers[] = null;

        ConcurrentSkipListSet<FixSequenceData> sequence = getData(code);

        if (sequence != null) {

            Iterator<FixSequenceData> iterator = sequence.iterator();
            System.out.println(" iterator " );

            int i = 0;
            numbers = new int[sequence.size()];

            while(iterator.hasNext()) {
                FixSequenceData fixSequenceData = iterator.next();
                if (fixSequenceData.getNumbers()>= 0) {

                    numbers[i] = fixSequenceData.getNumbers();
                    System.out.println(" numbers[i] " + numbers[i]);
                    i++;
                }
            }
            return numbers;
        }
        return null;
    }

    public void removeMarket(String code, String marketCode) {
        if (orderData.get(code) != null) {
            ConcurrentSkipListSet<FixSequenceData> sequence = orderData.get(code);
            Iterator<FixSequenceData> iterator = sequence.iterator();
            while(iterator.hasNext()) {
                FixSequenceData market = iterator.next();
                if (market.getCode().compareToIgnoreCase(marketCode)==0) {
                    sequence.remove(market);
                }
            }
        }
    }

    public void emptyAll() {
        if (orderData != null){
            orderData.clear();
        }
    }

    public int findMissingNumber(int N,int values[]) {
        int idealSum = (N*(N+1))/2;
        int sum = Arrays.stream(values).sum();
        int missingNumber = idealSum - sum;
        return missingNumber;
    }
}
