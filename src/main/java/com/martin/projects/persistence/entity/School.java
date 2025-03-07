package com.martin.projects.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(unique = true)
  private String email;
  private String address;
  private String city;
  private String state;
  private String postalCode;
  private String phone;

  @CreationTimestamp
  @Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Student> students;
}
