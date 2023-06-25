package com.orcaaa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId = UUID.randomUUID().toString();

    @NotBlank(message = "Nama pelanggan tidak boleh kosong")
    @Column(name = "customer_name")
    private String customerName;

    @NotBlank(message = "Alamat tidak boleh kosong")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Nomor telepon tidak boleh kosong")
    @Pattern(regexp = "(\\+62|0)[0-9]{9,12}", message = "Format nomor telepon tidak valid")
    @Column(name = "phone")
    private String phone;
}
