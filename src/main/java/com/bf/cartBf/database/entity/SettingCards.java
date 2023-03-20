package com.bf.cartBf.database.entity;

import com.bf.cartBf.util.MethodSelection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SettingCards {

    @Id
    private Long id;

    @Column(name = "method_selection")
    private MethodSelection methodSelection;
}
