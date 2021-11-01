package org.headstrait.redis.redisconsumer.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyData implements Serializable {
    @JsonProperty("DateTime")
    private long dateTime;
    @JsonProperty("Global_active_power")
    private String global_active_power;
    @JsonProperty("Global_reactive_power")
    private String global_reactive_power;
    @JsonProperty("Voltage")
    private String voltage;
    @JsonProperty("Global_intensity")
    private String global_intensity;
    @JsonProperty("Sub_metering_1")
    private String sub_metering_1;
    @JsonProperty("Sub_metering_2")
    private String sub_metering_2;
    @JsonProperty("Sub_metering_3")
    private String sub_metering_3;
    @JsonProperty("Temperature")
    private double temperature;

    @Override
    public String toString() {
        return "{" +
                "dateTime=" + dateTime +
                ", global_active_power='" + global_active_power + '\'' +
                ", global_reactive_power='" + global_reactive_power + '\'' +
                ", voltage='" + voltage + '\'' +
                ", global_intensity='" + global_intensity + '\'' +
                ", sub_metering_1='" + sub_metering_1 + '\'' +
                ", sub_metering_2='" + sub_metering_2 + '\'' +
                ", sub_metering_3='" + sub_metering_3 + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}