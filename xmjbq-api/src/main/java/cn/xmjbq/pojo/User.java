package cn.xmjbq.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author howinfun
 * @version 1.0
 * @desc
 * @date 2019/1/26
 * @company XMJBQ
 */
@Data
public class User implements Serializable {

    @NotEmpty
    private String name;

    @Range(min = 10,max = 20)
    private Integer age;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
