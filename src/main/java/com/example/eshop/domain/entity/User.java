package com.example.eshop.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "archive")
  private boolean archive;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToOne(cascade = CascadeType.REMOVE)
  private Bucket bucket;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    User user = (User) o;
    return archive == user.archive
        && Objects.equals(name, user.name)
        && Objects.equals(password, user.password)
        && Objects.equals(email, user.email)
        && role == user.role
        && Objects.equals(bucket, user.bucket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, password, email, archive, role, bucket);
  }
}
