package com.lumiin.mytalk.model;

import org.junit.Before;
import org.junit.Test;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class FixDataTest {

    FixDataList list = null;





    @Test
    public void checkRun(){

        System.out.println(" SIZE 1 " + list.getList().size());
        ConcurrentHashMap<String, ConcurrentSkipListSet<FixSequenceData>> result = list.getData();

        ConcurrentSkipListSet<FixSequenceData> outPut = list.getData("ORDER11111");
        NavigableSet<FixSequenceData> navigableSet = list.getData("ORDER11111");
        int higestNumber = navigableSet.pollLast().getNumbers();

        System.out.println("-- outPut 21: " + list.getNumbers("ORDER11111"));
        int[] missingNumbers = list.getNumbers("ORDER11111");

        int output = list.findMissingNumber(higestNumber,missingNumbers);
        System.out.println(" missingNumbers " + output + " navigableSet" + navigableSet.pollLast().getNumbers());


    }

    @Before
    public void loadData(){

        list = new FixDataList();
        FixSequenceData data1 = new FixSequenceData();
        //001 002 003 004
        data1.setNumbers(001);
        data1.setCode("ORDER11111");
        data1.setType('1');
        data1.setMessage("8=FIX.4.1\u00019=154\u000135=6\u000149=BRKR\u000156=INVMGR\u000134=239\u000152=19980604-08:00:36\u000123=115687\u000128=N\u000155=PIRI.MI\u000154=1\u000127=300000\u000144=5950.000000\u000125=H\u000110=168\u0001");
        list.addData("ORDER11111",data1);
        //dummy2.add(data1);



        FixSequenceData data3 = new FixSequenceData();
        //001 002 003 004
        data3.setNumbers(003);
        data3.setCode("ORDER11111");
        data3.setMessage("8=FIX.4.1\u00019=154\u000135=6\u000149=BRKR\u000156=INVMGR\u000134=239\u000152=19980604-08:00:36\u000123=115687\u000128=N\u000155=PIRI.MI\u000154=1\u000127=300000\u000144=5950.000000\u000125=H\u000110=168\u0001");
        //list.addSequence(data3);
        data3.setType('2');
        list.addData("ORDER11111",data3);
        //dummy2.add(data3);

        FixSequenceData data2 = new FixSequenceData();
        //001 002 003 004
        data2.setNumbers(002);
        data2.setCode("ORDER11111");
        data2.setMessage("8=FIX.4.1\u00019=154\u000135=6\u000149=BRKR\u000156=INVMGR\u000134=239\u000152=19980604-08:00:36\u000123=115687\u000128=N\u000155=PIRI.MI\u000154=1\u000127=300000\u000144=5950.000000\u000125=H\u000110=168\u0001");
        list.addData("ORDER11111",data2);
        //dummy2.add(data2);

    }
}
