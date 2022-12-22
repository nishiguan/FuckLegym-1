package fucklegym.top.entropy;

import android.content.SharedPreferences;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PathGenerator {
    //设置跑步范围经纬度坐标
    private static double[] latitude;
    private static double[] longitude;
    private static double base_lat, base_lon;

    public static HashMap<String, HashMap<String, double[]>> RunMaps = new HashMap<String, HashMap<String, double[]>>(){
        {
            put("重庆交通大学（科学城校区）", new HashMap<String, double[]>(){{
                put("latitude", new double[]{29.420487,29.42044,29.42037,29.42029,29.420253,29.420211,29.420136,29.42009,29.420057,29.420024,29.420005,29.419968,29.419914,29.419858,29.419807,29.419793,29.419751,29.419699,29.419648,29.419625,29.419587,29.419498,29.419438,29.419428,29.419419,29.419391,29.419368,29.41934,29.419326,29.419316,29.419288,29.41926,29.419269,29.419269,29.419274,29.419251,29.419251,29.419251,29.419251,29.419251,29.419241,29.419232,29.419241,29.419237,29.419223,29.419232,29.419232,29.419218,29.419213,29.419204,29.419185,29.419171,29.419171,29.419139,29.419129,29.419153,29.419185,29.419204,29.419237,29.419251,29.419288,29.419335,29.419382,29.419433,29.419442,29.419466,29.419484,29.419517,29.419536,29.419555,29.419573,29.419601,29.419643,29.419662,29.419676,29.419695,29.419709,29.419727,29.419737,29.419769,29.419798,29.419821,29.419844,29.419863,29.419886,29.419905,29.419938,29.419952,29.419961,29.419975,29.419998,29.420036,29.420059,29.420092,29.420125,29.420157,29.420171,29.42019,29.420195,29.420241,29.420246,29.420265,29.42026,29.420269,29.420288,29.420316,29.420326,29.420344,29.420358,29.420349,29.420377,29.420382,29.420405,29.420396,29.420419,29.420433,29.420466,29.420475,29.420484});
                put("longitude", new double[]{106.318445,106.318482,106.318547,106.318606,106.318654,106.318702,106.318767,106.318809,106.318826,106.318858,106.318858,106.318906,106.318949,106.318992,106.319024,106.319035,106.319067,106.319099,106.319126,106.319142,106.319163,106.319206,106.319228,106.319228,106.319174,106.319104,106.319035,106.318944,106.318895,106.318874,106.31874,106.318734,106.318729,106.318718,106.318713,106.318702,106.318691,106.318681,106.31867,106.318665,106.318659,106.318648,106.318643,106.318638,106.318632,106.318627,106.318616,106.318595,106.318573,106.318547,106.318498,106.318455,106.318423,106.318332,106.318284,106.318284,106.318273,106.318273,106.318262,106.318257,106.318235,106.31823,106.318214,106.318182,106.318166,106.318171,106.31816,106.318139,106.318134,106.318117,106.318128,106.318123,106.318069,106.318037,106.318042,106.318021,106.318026,106.318021,106.317994,106.317983,106.317951,106.317897,106.317881,106.317855,106.317855,106.317812,106.317796,106.317801,106.317774,106.317737,106.317726,106.317763,106.317806,106.317833,106.317881,106.317914,106.31793,106.317946,106.317973,106.318026,106.318032,106.318058,106.318074,106.318096,106.318117,106.318139,106.31816,106.318182,106.318193,106.318219,106.318252,106.318268,106.318289,106.318294,106.318316,106.318343,106.31838,106.318402,106.318445});
                put("base", new double[]{29.420487, 106.318445});
            }});
            put("电子科技大学（沙河校区）", new HashMap<String, double[]>(){{
                put("latitude", new double[]{30.676965, 30.676988, 30.67703, 30.677035, 30.677016, 30.676998, 30.676924, 30.67685, 30.676725, 30.676532, 30.676315, 30.676103, 30.67607, 30.676006, 30.675987, 30.675858, 30.675738, 30.675715, 30.675687, 30.675683, 30.675641, 30.675637, 30.675604, 30.675567, 30.675567, 30.675586, 30.675609, 30.675646, 30.67578, 30.675807, 30.675918, 30.675964, 30.676038, 30.676144, 30.676259, 30.676296, 30.676379, 30.676536, 30.676721, 30.676785, 30.676832, 30.676887});
                put("longitude", new double[]{104.097982, 104.098036, 104.098132, 104.098256, 104.098385, 104.098454, 104.098519, 104.098626, 104.098669, 104.098658, 104.098658, 104.098631, 104.098637, 104.098637, 104.098647, 104.098621, 104.098572, 104.098551, 104.098497, 104.098486, 104.09846, 104.098406, 104.098374, 104.098293, 104.098272, 104.098149, 104.098057, 104.097993, 104.097859, 104.097832, 104.097805, 104.097821, 104.097821, 104.097827, 104.097827, 104.097864, 104.097853, 104.097848, 104.097853, 104.097864, 104.097886, 104.097891});
                put("base", new double[]{30.676965, 104.097982});
            }});
            put("四川轻化工大学（宜宾校区）", new HashMap<String, double[]>(){{
                put("latitude", new double[ ]{28.811125，28.811125，28.811022，28.810933，28.810829，28.810829，28.810829，28.810829，28.810829，28.81058，28.81058，28.810467，28.810402，28.810322，28.810293，28.810252，28.810279，28.810232，28.810214，28.810228，28.810298，28.810397，28.810481，28.81059，28.811008，28.810655，28.810735，28.810886，28.810933，28.810984，28.811031，28.811083，28.811107，28.811158，28.811205，28.811243，28.811313，28.811337，28.811426，28.811464，28.811487，28.811511，28.811501，28.811492，28.811431，28.811384，28.811313，28.811248，28.811196});
                put("lontitude", new double[ ]{104.671726,28.811125
104.671726,104.671769,104.671817,104.671871,104.671871,104.671871,104.671871,104.671871,104.672021,104.672021,104.672086,104.672128,104.672161,104.672198,104.672269,104.672281,104.672386,104.672472,104.672633,104.672719,104.672804,104.672837,104.672837,104.672622,104.672799,104.672751,104.672681,104.67266,104.672627,104.672611,104.672574,104.672552,104.672525,104.672493,104.672466,104.672434,104.672418,104.672375,104.672311,104.672236,104.672128,104.672021,104.671935,104.671839,104.671785,104.671742,104.671737,104.671731});
                put("base", new double[ ]{28.811125，104.671726});
            }});
//"xx大学（xx校区）": {
//  "latitude": [],
//  "longitude": []
//}
        }
    };

    public static void getLocalMaps(SharedPreferences local_maps){
        String[] maps = new String[]{};
        Map<String, ?> all = local_maps.getAll();
        for(String str: all.keySet()){
            double[] attr = new double[]{};
            JSONArray latitude = JSON.parseObject((String) all.get(str)).getJSONArray("latitude");
            JSONArray longitude = JSON.parseObject((String) all.get(str)).getJSONArray("longitude");
            double[] latitude_double = latitude.toJavaObject(double[].class);
            double[] longitude_double = longitude.toJavaObject(double[].class);
            double[] base = new double[]{latitude_double[0], longitude_double[0]};
            HashMap<String, double[]> theMap = new HashMap<>();
            theMap.put("latitude", latitude_double);
            theMap.put("longitude", longitude_double);
            theMap.put("base", base);
            RunMaps.put(str, theMap);
        }
    }


    private static void setAttr(String map){
        HashMap<String, double[]> currentMap = RunMaps.get(map);
        latitude = currentMap.get("latitude");
        longitude = currentMap.get("longitude");
        base_lat = currentMap.get("base")[0];
        base_lon = currentMap.get("base")[1];
    }

//    public static ArrayList<Pair<Double,Double>> genPointsInUESTC(int count){
//        ArrayList<Pair<Double,Double>> points = new ArrayList<>();
//        Random rad = new Random(System.currentTimeMillis());
//        for(int i = 1;i<=count;i++){
//            points.add(new Pair(base_lat + rad.nextInt(10000) / 1000000.0/2.0,base_lon + rad.nextInt(10000) / 1000000.0/2.0));
//        }
//        return points;
//    }
    public static ArrayList<Pair<Double,Double>> genRegularRoutine(String map, double totalMile){
        int cycleMeter = 400;//操场一圈的长度
        int totalMeter = (int)(totalMile * 1000);
        int offset = 6;//经纬度随机偏移量
        setAttr(map);
        ArrayList<Pair<Double,Double>> points = new ArrayList<>();
        Random rad = new Random(System.currentTimeMillis());
        for(int j = 0;j <= totalMeter/cycleMeter;j ++){
            if(totalMeter/cycleMeter - j - 1 >= 0) {
                for (int i = 0; i < latitude.length; i++) {
                    points.add(new Pair(latitude[i] + rad.nextInt(offset) * 1e-5, longitude[i] + rad.nextInt(offset) * 1e-5));
                }
            }else {
                int lastMeter = totalMeter - j * cycleMeter;
                double rate = ((double) lastMeter)/((double)cycleMeter);
                Log.d("run_rate", "genRegularRoutine: " + rate);
                for (int i = 0; i < latitude.length*rate; i++) {
                    points.add(new Pair(latitude[i] + rad.nextInt(offset) * 1e-5, longitude[i] + rad.nextInt(offset) * 1e-5));
                }
            }
        }

        return points;
    }

}
