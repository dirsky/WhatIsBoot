package com.frank.boot.entities;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Emp extends Model<Emp> {
    @Id
    private Integer id;
    @NotNull(message = "不能为空")
    private String name;
    private String email;
    private Integer gender;
    private Integer age;
}
