package com.krushidj.tenantapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -2352384180541497780L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "barcode_id")
    private long barcodeId;

    @Column(name = "faulty")
    private boolean isFaulty;

    private String remark;

    @Column(name = "product_char_id")
    @NotNull
    private int charId;

    @Column(name = "warranty_date")
    private Date warrantyDate;

    @Column(name = "purches_date")
    private Date purchesDate;

    private String company;

    @Column(name = "available")
    private boolean isAvailable;

    @JsonIgnore
    private boolean active = true;
    private String name;

}
