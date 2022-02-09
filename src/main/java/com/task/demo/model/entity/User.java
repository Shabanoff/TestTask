package com.task.demo.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "user_id")
    private Long userId;

    @NonNull
    @Column(name = "level_id")
    private Long levelId;

    @NonNull
    @Column(name = "result")
    private Long result;
}
