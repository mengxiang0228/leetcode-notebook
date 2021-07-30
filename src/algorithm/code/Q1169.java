package algorithm.code;


import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * 1169. 查询无效交易
 * 如果出现下述两种情况，交易 可能无效：
 *
 *     交易金额超过 ¥1000
 *     或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 *
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 *
 示例 1：

 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。

 *
 * @author liyaxiang
 * @since 2021/6/24 16:06
 */
public class Q1169 {

    @Test
    public void test1(){
        String[] transactions = new String[]{"alice,20,800,mtv","alice,50,100,beijing"};
        List<String> list = invalidTransactions(transactions);
        for (String s : list) {
            System.out.print(s);
        }

        System.out.println();
        transactions = new String[]{"alice,20,800,mtv","alice,50,1200,mtv"};
        list = invalidTransactions(transactions);
        for (String s : list) {
            System.out.print(s);
        }

        System.out.println();
        transactions = new String[]{"alice,20,800,mtv","bob,50,1200,mtv"};
        list = invalidTransactions(transactions);
        for (String s : list) {
            System.out.print(s);
        }
    }
    @Test
    public void test2(){
//        String[] transactions = new String[]{"alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"};

//        String[] transactions = new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona",
//         "bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"};

//        String[] transactions = new String[]{"bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona",
//         "alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"};

        String[] transactions = new String[]{"alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"};
        List<String> list = invalidTransactions(transactions);
        for (String s : list) {
            System.out.print(s+ "\t\t");
        }
    }

    public static List<String>  invalidTransactions(String[] transactions){
        if(transactions.length == 0){
            return new ArrayList<>(0);
        }
        List<String> resultList = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        Set<Integer> resultIdSet = new HashSet<>();
        Transaction transaction = null;
        int i = 0;

        String orderName = null;
        Integer money = null;
        String[] splitList = null;
        boolean checkSuccess = true;
        List<Transaction> orderTimeList = null;
        for (String s : transactions) {
            splitList = s.split(",");
            orderName = splitList[0];
            money = Integer.valueOf(splitList[2]);
            transaction = new Transaction(Integer.valueOf(splitList[1]), splitList[3], i++);

            orderTimeList = map.get(orderName);
            if(orderTimeList == null){
                orderTimeList = new ArrayList<>();
                map.put(orderName, orderTimeList);
            }
            checkSuccess = true;
            if(money > 1000){
                checkSuccess = false;
            }
            for (Transaction checkTransaction : orderTimeList) {
                if(Math.abs(checkTransaction.time-transaction.time) <= 60 && !transaction.address.equals(checkTransaction.address)){
                    if(resultIdSet.add(checkTransaction.id)){
                        resultList.add(transactions[checkTransaction.id]);
                    }
                    checkSuccess = false;
                }
            }
            if(!checkSuccess){
                resultList.add(s);
                resultIdSet.add(transaction.id);
            }
            orderTimeList.add(transaction);

        }
        return resultList;
    }


    /**
     * 交易对象
     */
    static class Transaction {
        private Integer time;
        private String address;
        private Integer id;

        public Transaction(Integer time, String address, Integer id) {
            this.time = time;
            this.address = address;
            this.id = id;
        }

    }
}
