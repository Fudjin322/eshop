package com.example.eshop.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buckets")
public class Bucket extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "bucket")
  @JoinTable(
      name = "buckets_products",
      joinColumns = @JoinColumn(name = "bucket_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products = new java.util.ArrayList<>();
}
