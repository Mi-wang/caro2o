package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final Integer STATUS_APPOINTMENT = 0;//预约中
    public static final Integer STATUS_ARRIVAL = 1;//已到店
    public static final Integer STATUS_CANCEL = 2;//用户取消
    public static final Integer STATUS_OVERTIME = 3;//超时取消
    public static final Integer STATUS_SETTLE  = 4;//已结算
    public static final Integer STATUS_PAID  = 5;//已支付

    private Long id;
    private String customerName;                    //客户姓名
    private String customerPhone;                   //客户联系方式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//当对象被解析成JSON格式的时候,按照注解的方式解析日期类型/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")//接收前台传入日期对象,需要指定格式.
    private Date appointmentTime;                   //预约时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //如果前台参数和pattern一致是没问题的.
    //前台传入的格式   2021-12-01 12:00:05
    //前台传入的格式   2021-12-01 12
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date actualArrivalTime;                 //实际到店时间
    private String licensePlate;                    //车牌号码
    private String carSeries;                       //汽车类型
    private Integer serviceType;                    //客服务类型【维修0/保养1】
    private Date createTime;                        //创建时间
    private String info;                            //备注信息
    private Integer status = STATUS_APPOINTMENT;    //状态【预约中0/已到店1/用户取消2/超时取消3】
}