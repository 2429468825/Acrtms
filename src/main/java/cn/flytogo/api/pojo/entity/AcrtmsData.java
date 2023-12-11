package cn.flytogo.api.pojo.entity;

import lombok.Data;


@Data
public class AcrtmsData {

    /**
     * 数据id
     */
    String id;

    /**
     * UTC时间
     * yyyyMMddhhmss
     */
    String time;

    /**
     *  纬度
     */
    String latitude;

    /**
     *  经度
     */
    String longitude;

    /**
     *  海拔
     */
    String altitude;

    /**
     * 对地速度
     */
    String speed;

    /**
     * 对地航向
     */
    String ground;

    /**
     * 定位状态
     */
    String status;

    /**
     * 定位模式
     */
    String mode;

    public static AcrtmsData parse(String input) {
        AcrtmsData acrtmsData = new AcrtmsData();


        if (input.endsWith(";")) {
            input = input.substring(0, input.length() - 1);
        }
        String[] parts = input.split(",");
        if (parts.length >= 9) {
            acrtmsData.setId(null); // Set your ID logic here if needed
            acrtmsData.setTime(parts[1]);
            acrtmsData.setLatitude(parts[2]);
            acrtmsData.setLongitude(parts[3]);
            acrtmsData.setAltitude(parts[4]);
            acrtmsData.setSpeed(parts[5]);
            acrtmsData.setGround(parts[6]);
            acrtmsData.setStatus(parts[7]);
            acrtmsData.setMode(parts[8]);
        }

        return acrtmsData;
    }

    @Override
    public String toString() {
        return ">>>" + id + "\n" +
                time + "\n" +
                latitude + "\n" +
                longitude + "\n" +
                altitude + "\n" +
                speed + "\n" +
                ground + "\n" +
                status + "\n" +
                mode + "\n";
    }

}
